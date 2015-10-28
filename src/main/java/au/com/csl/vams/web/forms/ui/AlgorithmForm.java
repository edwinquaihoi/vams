package au.com.csl.vams.web.forms.ui;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IAlgorithmSvc;

@ManagedBean(name = "algForm")
@ViewScoped
public class AlgorithmForm extends AbstractMaintenanceForm<String, Algorithm> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6784299437633859252L;
	
	@EJB
	private IAlgorithmSvc algorithmSvc;
	
	public IAlgorithmSvc getAlgorithmSvc() {
		return algorithmSvc;
	}

	public void setAlgorithmSvc(IAlgorithmSvc algorithmSvc) {
		this.algorithmSvc = algorithmSvc;
	}

	@Override
	public Algorithm getNewOne() {
		return new Algorithm();
	}

	@Override
	public List<Algorithm> getDefaultSearchResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityBusinessName() {
		return "Algorithm";
	}

	@Override
	public IService getService() {
		return algorithmSvc;
	}

}
