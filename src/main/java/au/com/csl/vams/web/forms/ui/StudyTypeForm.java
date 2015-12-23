package au.com.csl.vams.web.forms.ui;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.model.relational.PlateType;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.model.relational.StudyType;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IAlgorithmSvc;
import au.com.csl.vams.service.IPlateTypeSvc;
import au.com.csl.vams.service.IStudyTypeSvc;

@ManagedBean(name = "studyTypeForm")
@ViewScoped
public class StudyTypeForm extends AbstractMaintenanceForm<String, StudyType> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3321292685066465547L;

	@EJB
	private IStudyTypeSvc studyTypeSvc;
	
	@EJB
	private IAlgorithmSvc algorithmSvc;
	
	@EJB
	private IPlateTypeSvc plateTypSvc;
	
	private List<Algorithm> algrthms;
	
	private List<PlateType> plateTyps;
	
	private String name;
	
	private String algtype;
	
	private String platetype;
	
	private StudyType selectedStudyType;
	
	private List<StudyType> filteredStudytypes;
	
	private boolean disable;
	
	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public StudyType getSelectedStudyType() {
		return selectedStudyType;
	}

	public void setSelectedStudyType(StudyType selectedStudyType) {
		this.selectedStudyType = selectedStudyType;
	}

	public List<StudyType> getFilteredStudytypes() {
		return filteredStudytypes;
	}

	public void setFilteredStudytypes(List<StudyType> filteredStudytypes) {
		this.filteredStudytypes = filteredStudytypes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlgtype() {
		return algtype;
	}

	public void setAlgtype(String algtype) {
		this.algtype = algtype;
	}

	public String getPlatetype() {
		return platetype;
	}

	public void setPlatetype(String platetype) {
		this.platetype = platetype;
	}

	public IStudyTypeSvc getStudyTypeSvc() {
		return studyTypeSvc;
	}

	public IAlgorithmSvc getAlgorithmSvc() {
		return algorithmSvc;
	}

	public void setAlgorithmSvc(IAlgorithmSvc algorithmSvc) {
		this.algorithmSvc = algorithmSvc;
	}

	public void setStudyTypeSvc(IStudyTypeSvc studyTypeSvc) {
		this.studyTypeSvc = studyTypeSvc;
	}
			
	public IPlateTypeSvc getPlateTypSvc() {
		return plateTypSvc;
	}

	public void setPlateTypSvc(IPlateTypeSvc plateTypSvc) {
		this.plateTypSvc = plateTypSvc;
	}

	public List<Algorithm> getAlgrthms() {
		return algrthms;
	}

	public void setAlgrthms(List<Algorithm> algrthms) {
		this.algrthms = algrthms;
	}
		
	public List<PlateType> getPlateTyps() {
		return plateTyps;
	}

	public void setPlateTyps(List<PlateType> plateTyps) {
		this.plateTyps = plateTyps;
	}

	@Override
	public StudyType getNewOne() {
		StudyType stdTyp = new StudyType();
		stdTyp.setAlgorithm(new Algorithm());
		stdTyp.setPlateType(new PlateType());
		algrthms = new ArrayList<Algorithm>();
		plateTyps = new ArrayList<PlateType>();
		algrthms = algorithmSvc.getAll();
		plateTyps = plateTypSvc.getAll();
		return stdTyp;
	}

	@Override
	public List<StudyType> getDefaultSearchResults() {
		name = "";
		algtype = "";
		platetype = "";
		return studyTypeSvc.getAll();

	}

	@Override
	public String getEntityBusinessName() {
		return "Study Type";
	}
	
	@PostConstruct
	public void init()
	{
		algrthms = algorithmSvc.getAll();
		plateTyps = plateTypSvc.getAll();
	}

	@Override
	public IService getService() {
		return studyTypeSvc;
	}
	
	public void searchByIDOrName() {
		List<StudyType> studyTyps;
		if (getName().isEmpty() && getAlgtype().isEmpty() && getPlatetype().isEmpty()) {
			studyTyps = studyTypeSvc.getAll();
		} else {
			studyTyps = studyTypeSvc.findByNameLikeOrAlgorithmNameContainingOrPlateTypeNameContaining(
					(getName().isEmpty() ? "null" : getName() + "%"), (getAlgtype().isEmpty() ? "null" : getAlgtype()),
					(getPlatetype().isEmpty() ? "null" : getPlatetype()));
		}
		getSessionModel().setResults(studyTyps);
	}
	
	public void onRowSelect(SelectEvent event) {
		StudyType studyTyp = (StudyType) event.getObject();
		getSessionModel().setModel(studyTyp);
		viewOne(studyTyp);

		algrthms.clear();
		algrthms.add(studyTyp.getAlgorithm());

		plateTyps.clear();
		plateTyps.add(studyTyp.getPlateType());
		setDisable(true);

	}
	
	@Override
	public void viewOne(StudyType studyType) {
		super.viewOne(studyType);
		algrthms.clear();
		plateTyps.clear();
		algrthms.add(studyType.getAlgorithm());
		plateTyps.add(studyType.getPlateType());

	}
	
	
}
