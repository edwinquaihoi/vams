package au.com.csl.vams.web.forms.ui;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import au.com.csl.vams.model.relational.PlateType;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IPlateTypeSvc;

@ManagedBean(name = "plateTypForm")
@ViewScoped
public class PlateTypeForm extends AbstractMaintenanceForm<String, PlateType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6438160136371414570L;
	
	@EJB
	private IPlateTypeSvc plateTypeSvc;
		
	public IPlateTypeSvc getPlateTypeSvc() {
		return plateTypeSvc;
	}

	public void setPlateTypeSvc(IPlateTypeSvc plateTypeSvc) {
		this.plateTypeSvc = plateTypeSvc;
	}

	@Override
	public PlateType getNewOne() {
		return new PlateType();
	}

	@Override
	public List<PlateType> getDefaultSearchResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityBusinessName() {
		return "Plate Type";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public IService getService() {
		return plateTypeSvc;
	}

	
}
