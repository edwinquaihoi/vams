package au.com.csl.vams.web.forms.ui;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IPlateSvc;
import au.com.csl.vams.service.IRunSvc;
import au.com.csl.vams.service.IStudySvc;

@ManagedBean(name = "runForm")
@ViewScoped
public class RunForm extends AbstractMaintenanceForm<String, Run> {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -2873561682266173077L;

	private static final Logger logger = LoggerFactory.getLogger(RunForm.class);
	
	@EJB
	private IRunSvc runSvc;
	
	@EJB
	private IStudySvc studySvc;
	
	@EJB 
	private IPlateSvc plateSvc;
		
	@ManagedProperty("#{plateModel}")
	PlateModel plateModel;
	
	private boolean disable;
	
	private Study study;
	
	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

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
		
	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
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
	
	@Override
	public String save() {
		String sName = getSessionModel().getModel().getStudy().getName();
		String sId = getSessionModel().getModel().getStudy().getId();
		List<Study> studyLst=studySvc.findByNameLikeOrIdContainingOrStudyTypeNameContaining(sName.isEmpty() ? "null" : "%"+sName+"%", sId.isEmpty() ? "null": sId, "null");
		List<Run> runLst=runSvc.findByStudyId(getSessionModel().getModel().getStudy().getId()); 
		if (!studyLst.isEmpty() || !runLst.isEmpty()) {
			for (Study study : studyLst) {
				getSessionModel().getModel().setStudy(study);
			}
			super.save();
		}
		setDisable(true);
		Run r= runSvc.getById(getSessionModel().getModel().getId());
		getSessionModel().getModel().setStudy(r.getStudy());
		return null;
	}
	
	@Override
	public void viewOne(Run run)
	{
		super.viewOne(run);
		setDisable(true);
	}
	
	@Override
	public void viewNewOne()
	{
		super.viewNewOne();
		getSessionModel().getModel().setStudy(study);
	}



}
