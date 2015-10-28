package au.com.csl.vams.web.forms.ui;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.model.relational.PlateType;
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
			return stdTyp;
	}

	@Override
	public List<StudyType> getDefaultSearchResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityBusinessName() {
		return "Study Type";
	}

	@Override
	public IService getService() {
		return studyTypeSvc;
	}
	
	@PostConstruct
	public void init()
	{
		setAlgrthms(algorithmSvc.getAll());
		setPlateTyps(plateTypSvc.getAll());
	}

}
