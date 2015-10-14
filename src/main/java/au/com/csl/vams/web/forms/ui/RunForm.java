package au.com.csl.vams.web.forms.ui;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IPlateSvc;
import au.com.csl.vams.service.IRunSvc;
import au.com.csl.vams.service.IStudySvc;
import au.com.csl.vams.utils.PageDetails;




@ManagedBean(name = "runForm")
@ViewScoped
public class RunForm extends AbstractMaintenanceForm<String, Run> {
	
	private static final long serialVersionUID = 2L;
	
	private static final Logger logger = LoggerFactory.getLogger(RunForm.class);
	
	@EJB
	private IRunSvc runSvc;
	
	@EJB
	private IStudySvc studySvc;
	
	@EJB 
	private IPlateSvc plateSvc;
		
	@ManagedProperty("#{plateModel}")
	PlateModel plateModel;
				
	
	public IPlateSvc getPlateSvc() {
		return plateSvc;
	}

	public void setPlateSvc(IPlateSvc plateSvc) {
		this.plateSvc = plateSvc;
	}

	public PlateModel getPlateModel() {
		return plateModel;
	}

	public void setPlateModel(PlateModel plateModel) {
		this.plateModel = plateModel;
	}

	public IStudySvc getStudySvc() {
		return studySvc;
	}

	public void setStudySvc(IStudySvc studySvc) {
		this.studySvc = studySvc;
	}

	public IRunSvc getRunSvc() {
		return runSvc;
	}

	public void setRunSvc(IRunSvc runSvc) {
		this.runSvc = runSvc;
	}

	@Override
	public Run getNewOne() {
		Run run= new Run();
		run.setStudy(new Study());
		return run;
	}

	@Override
	public List<Run> getDefaultSearchResults() {
		// TODO Auto-generated method stubr
		return null;
	}

	@Override
	public String getEntityBusinessName() {
		return "run";
	}

	@Override
	public IService getService() {
		return runSvc;
	}
	
		
	public void addPlate()
	{
		List<Study> studyLst=null;
		List<Run> runLst=null;
		Run run = null;
		if(!getSessionModel().getModel().getStudy().getStudyName().isEmpty() || !getSessionModel().getModel().getStudy().getId().isEmpty())
		{
			studyLst=studySvc.findByStudyNameContainingOrIdContaining(getSessionModel().getModel().getStudy().getStudyName(), getSessionModel().getModel().getStudy().getId());
		}
		else if(!getSessionModel().getModel().getId().isEmpty() && (!getSessionModel().getModel().getStudy().getStudyName().isEmpty() || !getSessionModel().getModel().getStudy().getId().isEmpty()))
		{
			runLst=runSvc.findByStudyId(getSessionModel().getModel().getStudy().getId()); // if not null run exist and do n't add new on add run new
		}
		
		System.out.println("studyLst***"+studyLst.toString());
		if (!studyLst.isEmpty()) {
			for (Study study : studyLst) {
				if(study.getRuns() == null)
					run = new Run();
					run.setStudy(study);
					runSvc.create(run);

			}
			
			//create a new plate
			//add run to that plate
			// set that as model
			
			Plate plate = new Plate();
			plate.setRun(run);
			plateSvc.create(plate);
			//getSessionModel().setModel(plate);
			//getPlateModel().setPlate(plate);
			//getSessionModel().addPage(new PageDetails("ui/plate/plate.xhtml", null, "PlateForm"));
			//getSessionModel().addPage(new PageDetails(plateSvc.create(plate), "ui/plate/plate.xhtml", null, null));
			getSessionModel().setContent("ui/plate/plate.xhtml");
			
			
			
		}
	
		
	}



}
