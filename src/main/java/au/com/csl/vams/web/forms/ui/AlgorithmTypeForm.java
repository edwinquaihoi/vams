package au.com.csl.vams.web.forms.ui;



import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import au.com.csl.vams.model.relational.AlgorithmType;
import au.com.csl.vams.model.relational.AlgorithmTypeParameter;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IAlgorithmTypeSvc;




@ManagedBean(name = "algTypeForm")
@ViewScoped
public class AlgorithmTypeForm extends AbstractMaintenanceForm<String, AlgorithmType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6846419896848061928L;
	
	@EJB
	private IAlgorithmTypeSvc algTypeSvc;
			
	private String name;
	
	private AlgorithmTypeParameter algtypeparam;
	
	private List<AlgorithmType> filteredalgtypes;
	
	private AlgorithmType selectedAlgType;
		
	
	public List<AlgorithmType> getFilteredalgtypes() {
		return filteredalgtypes;
	}

	public void setFilteredalgtypes(List<AlgorithmType> filteredalgtypes) {
		this.filteredalgtypes = filteredalgtypes;
	}

	public AlgorithmType getSelectedAlgType() {
		return selectedAlgType;
	}

	public void setSelectedAlgType(AlgorithmType selectedAlgType) {
		this.selectedAlgType = selectedAlgType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IAlgorithmTypeSvc getAlgTypeSvc() {
		return algTypeSvc;
	}

	public void setAlgTypeSvc(IAlgorithmTypeSvc algTypeSvc) {
		this.algTypeSvc = algTypeSvc;
	}
	
	public AlgorithmTypeParameter getAlgtypeparam() {
		return algtypeparam;
	}

	public void setAlgtypeparam(AlgorithmTypeParameter algtypeparam) {
		this.algtypeparam = algtypeparam;
	}
	
	@PostConstruct
	public void init() {
		algtypeparam = new AlgorithmTypeParameter();
	}

	@Override
	public AlgorithmType getNewOne() {
		AlgorithmType type = new AlgorithmType();
		type.setParameters(new ArrayList<AlgorithmTypeParameter>());
		return type;
	}

	@Override
	public List<AlgorithmType> getDefaultSearchResults() {
		name = "";
		return algTypeSvc.getAll();

	}

	@Override
	public String getEntityBusinessName() {
		return "algorithmtype";
	}

	@Override
	public IService getService() {
		return algTypeSvc;
	}
	
	public void createNew() {
	  if(getSessionModel().getModel().getParameters().contains(algtypeparam)) {
	            FacesMessage msg = new FacesMessage("Duplicated", "This Parameter has already been added");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        } 
	        else {
	        	getSessionModel().getModel().getParameters().add(algtypeparam);
	        	algtypeparam = new AlgorithmTypeParameter();
	        }
	}
	
	public String reinit() {
		algtypeparam = new AlgorithmTypeParameter();
		return null;
	}
	
	/*@Override
	public String save()
	{
		getSessionModel().getModel().setParameters(parameters);
		algTypeSvc.update(getSessionModel().getModel());
		return null;
	}*/
	
	public void onRowSelect(SelectEvent event) {
		AlgorithmType algtype = (AlgorithmType) event.getObject();
		getSessionModel().setModel(algtype);
		viewOne(algtype);

	}
	
	public void searchByName() {
		List<AlgorithmType> algtypes;
		if (getName().isEmpty()) {
			algtypes = algTypeSvc.getAll();
		} else {
			algtypes = algTypeSvc.findByNameLike((getName().isEmpty() ? "null" : getName() + "%"));
		}
		getSessionModel().setResults(algtypes);
	}

}
