package au.com.csl.vams.web.forms.ui;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.Run;

@ManagedBean
@ViewScoped
public class PlateModel implements Serializable {
	
	private static final long serialVersionUID = -1L;
	
	private Plate plate;
	
	private Run run;

	public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
		this.run = run;
	}
	


}
