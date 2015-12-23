package au.com.csl.vams.web.forms.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;

import au.com.csl.vams.config.ConfigUtil;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.model.relational.AlgorithmParameter;
import au.com.csl.vams.model.relational.AlgorithmType;
import au.com.csl.vams.model.relational.AlgorithmTypeParameter;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IAlgorithmSvc;
import au.com.csl.vams.service.IAlgorithmTypeSvc;

@ManagedBean(name = "algForm")
@ViewScoped
public class AlgorithmForm extends AbstractMaintenanceForm<String, Algorithm> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6784299437633859252L;
	
	@EJB
	private IAlgorithmSvc algorithmSvc;
	
	@EJB
	private IAlgorithmTypeSvc algTypeSvc;
	
	private List<AlgorithmType> algTypes;
	
	private AlgorithmParameter algParam;
	
	private List<Algorithm> filteredalgs;
	
	private Algorithm selectedAlg;
	
	private String name;
	
	private DataTable myTable;
						
	public DataTable getMyTable() {
		return myTable;
	}

	public void setMyTable(DataTable myTable) {
		this.myTable = myTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Algorithm> getFilteredalgs() {
		return filteredalgs;
	}

	public void setFilteredalgs(List<Algorithm> filteredalgs) {
		this.filteredalgs = filteredalgs;
	}

	public Algorithm getSelectedAlg() {
		return selectedAlg;
	}

	public void setSelectedAlg(Algorithm selectedAlg) {
		this.selectedAlg = selectedAlg;
	}

	public IAlgorithmTypeSvc getAlgTypeSvc() {
		return algTypeSvc;
	}

	public void setAlgTypeSvc(IAlgorithmTypeSvc algTypeSvc) {
		this.algTypeSvc = algTypeSvc;
	}
			
	public List<AlgorithmType> getAlgTypes() {
		return algTypes;
	}

	public void setAlgTypes(List<AlgorithmType> algTypes) {
		this.algTypes = algTypes;
	}

	public IAlgorithmSvc getAlgorithmSvc() {
		return algorithmSvc;
	}

	public void setAlgorithmSvc(IAlgorithmSvc algorithmSvc) {
		this.algorithmSvc = algorithmSvc;
	}
	
	
	
	public AlgorithmParameter getAlgParam() {
		return algParam;
	}

	public void setAlgParam(AlgorithmParameter algParam) {
		this.algParam = algParam;
	}

	@PostConstruct
	public void init() {
		algTypes = algTypeSvc.getAll();
		algParam = new AlgorithmParameter();
	}
	
	public String reinit() {
		algParam = new AlgorithmParameter();
		return null;
	}
	
	public void onRowSelect(SelectEvent event) {
		Algorithm alg = (Algorithm) event.getObject();
		getSessionModel().setModel(alg);
		viewOne(alg);

	}
	
	public void createNew() {
		  if(getSessionModel().getModel().getParameters().contains(algParam)) {
		            FacesMessage msg = new FacesMessage("Duplicated", "This Parameter has already been added");
		            FacesContext.getCurrentInstance().addMessage(null, msg);
		        } 
		        else {
		        	getSessionModel().getModel().getParameters().add(algParam);
		        	algParam = new AlgorithmParameter();
		        }
		}

	@Override
	public Algorithm getNewOne() {
		Algorithm alg = new Algorithm();
		alg.setAlgType(new AlgorithmType());
		setAlgTypes(algTypeSvc.getAll());
		alg.setParameters(new ArrayList<AlgorithmParameter>());
		return alg;
	}

	@Override
	public List<Algorithm> getDefaultSearchResults() {
		name = "";
		return algorithmSvc.getAll();
	}

	@Override
	public String getEntityBusinessName() {
		return "Algorithm";
	}

	@Override
	public IService getService() {
		return algorithmSvc;
	}
	
	@Override
	public void viewOne(Algorithm alg)
	{
		super.viewOne(alg);
		System.out.println(alg.getAlgType());
		/*algTypes.clear();
		algTypes.add(alg.getAlgType());*/
		
	}


	public String saveAlg()
	{
		if (myTable.getRowCount() < 1) {
				ConfigUtil.growl("Info", "Add a parameter");
			   return null; // reload view
		}
		else
		{
			super.save();
		}
		return null;
		
	}
	
	public void searchByName() {
		List<Algorithm> algs;
		if (getName().isEmpty()) {
			algs = algorithmSvc.getAll();
		} else {
			algs = algorithmSvc.findByNameLike((getName().isEmpty() ? "null" : getName() + "%"));
		}
		getSessionModel().setResults(algs);
	}
	
}
