package au.com.csl.vams.web.forms.ui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IPlateSvc;
import au.com.csl.vams.service.IRunSvc;
import au.com.csl.vams.service.IStudySvc;



@ManagedBean(name = "plateForm")
@ViewScoped
public class PlateForm extends AbstractMaintenanceForm<String, Plate> {
	
	@EJB 
	private IPlateSvc plateSvc;
	
	@EJB 
	private IRunSvc runSvc;
	
	@EJB
	private IStudySvc studySvc;
		
	public IStudySvc getStudySvc() {
		System.out.println("in plateform");
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

	public IPlateSvc getPlateSvc() {
		return plateSvc;
	}

	public void setPlateSvc(IPlateSvc plateSvc) {
		this.plateSvc = plateSvc;
	}

	@Override
	public List<Plate> getDefaultSearchResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityBusinessName() {
		return "plate";
	}

	@Override
	public IService getService() {
		return plateSvc;
	}

	@Override
	public Plate getNewOne() {
		Plate plate = new Plate();
		//Run run = new Run();
		//plate.setRun(run);
		return plate;
	}
	
	
}
