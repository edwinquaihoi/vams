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
	
	private String rows;
	
	private String cols;
				
	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getCols() {
		return cols;
	}

	public void setCols(String cols) {
		this.cols = cols;
	}

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

	@Override
	public String save()
	{
		getSessionModel().getModel().setName(rows+"*"+cols);
		plateTypeSvc.create(getSessionModel().getModel());
		viewOne(getSessionModel().getModel());
		return null;
		
	}
}
