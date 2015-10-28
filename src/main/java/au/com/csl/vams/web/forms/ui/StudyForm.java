package au.com.csl.vams.web.forms.ui;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.model.relational.StudyType;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IPlateSvc;
import au.com.csl.vams.service.IRunSvc;
import au.com.csl.vams.service.IStudySvc;
import au.com.csl.vams.service.IStudyTypeSvc;


@ManagedBean(name = "studyForm")
@ViewScoped
public class StudyForm  extends AbstractMaintenanceForm<String, Study>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8506037334355863770L;

	/**
	 * 
	 */

	private static Logger logger = LoggerFactory.getLogger(StudyForm.class); 
	
	private List<StudyType> studytypes;
		
	@EJB
	private IStudySvc studySvc;
	
	@EJB
	private IStudyTypeSvc studyTypeSvc;
	
	@EJB
	private IRunSvc runSvc;
	
	@EJB
	private IPlateSvc plateSvc;
		
	private String id;
	
	private String name;
	
	private String type;
	
	private Study selectedStudy;
	
	private List<Study> filteredStudies;
	
	private boolean disable;
			
	
	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public Study getSelectedStudy() {
		return selectedStudy;
	}

	public void setSelectedStudy(Study selectedStudy) {
		this.selectedStudy = selectedStudy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Study> getFilteredStudies() {
		return filteredStudies;
	}

	public void setFilteredStudies(List<Study> filteredStudies) {
		this.filteredStudies = filteredStudies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IStudyTypeSvc getStudyTypeSvc() {
		return studyTypeSvc;
	}

	public void setStudyTypeSvc(IStudyTypeSvc studyTypeSvc) {
		this.studyTypeSvc = studyTypeSvc;
	}

	public IStudySvc getStudySvc() {
		return studySvc;
	}

	public void setStudySvc(IStudySvc studySvc) {
		this.studySvc = studySvc;
	}

	public List<StudyType> getStudytypes() {
		return studytypes;
	}

	public void setStudytypes(List<StudyType> studytypes) {
		this.studytypes = studytypes;
	}

	public IRunSvc getRunSvc() {
		return runSvc;
	}

	public void setRunSvc(IRunSvc runSvc) {
		this.runSvc = runSvc;
	}
	
	public IPlateSvc getPlateSvc() {
		return plateSvc;
	}

	public void setPlateSvc(IPlateSvc plateSvc) {
		this.plateSvc = plateSvc;
	}

	@Override
	public Study getNewOne() {
		Study study = new Study();
		study.setStudyType(new StudyType());
		return study;
	}

	@Override
	public String getEntityBusinessName() {
		return "study";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public IService getService() {
		return studySvc;
	}

	@Override
	public List<Study> getDefaultSearchResults() {
		return studySvc.getAll();
	}
	
	@PostConstruct
	public void init() {
		setStudytypes(studyTypeSvc.getAll());
	}
	
	public void searchByIDOrName() {
		List<Study> studies = studySvc.findByNameLikeOrIdContainingOrStudyTypeNameContaining((getName().isEmpty() ? "null" : getName()+"%"),(getId().isEmpty() ? "null" : getId()), (getType().isEmpty() ? "null" : getType()));
		getSessionModel().setResults(studies);
	}
	
	public void getRuns(Study study) {
		
		List<Run> runs=runSvc.findByStudyId(study.getId());
		for(Run run :runs)
		{
			//List<Plate> plates= plateSvc.getPlates(run);
			//for(Plate plate:plates)
			//{
				//Plate p=plateSvc.getById(plate.getId());
				//System.out.println("plates***"+run+"*****"+p.toString());
			List<Plate> plates= plateSvc.getPlates(run);
				//System.out.println("plates***"+run+"*****"+plates.get(0).getPlateElmns().toString());
			//}
			
			
			run.setPlates(plates);
		}
		getSessionModel().getModel().setRuns(runs);
	}
	
	public void onRowSelect(SelectEvent event) {
		Study study = (Study) event.getObject();
		getSessionModel().setModel(study);
		getRuns(study);
		viewOne(study);
		studytypes.clear();
		studytypes.add(study.getStudyType());
		setDisable(true);

	}
	
	@Override
	public String save()
	{
		super.save();
		setDisable(true);
		return null;
	}
	
	
	
}
