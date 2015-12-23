package au.com.csl.vams.model.relational;


import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import au.com.csl.vams.scaffold.AbstractMasterEntity;

/**
 * @author chamun
 *
 */

@Entity
public class Plate extends AbstractMasterEntity<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
		
	private String name;
	
	@ManyToOne
	private Run run;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "PLATE_ID")
    private List<PlateElement> plateElmns;
	
	@JoinColumn(name = "PLATETYPE", nullable = false)
	@ManyToOne
	private PlateType plateType;	
	
	/*@OneToOne
	private Sample sample;*/
	
	@Transient
	private Map<String,Map<String,Boolean>> vals;
	
	@Transient
	private List< Map<String,Map<String,Boolean>>> valLst;
	
	@Transient
	private Map<String,String> rows;
	
	@Transient
	private Map<String,String> cols;
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
		this.run = run;
	}

	public List<PlateElement> getPlateElmns() {
		return plateElmns;
	}

	public void setPlateElmns(List<PlateElement> plateElmns) {
		this.plateElmns = plateElmns;
	}
								
	/*public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}*/
	

	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public PlateType getPlateType() {
		return plateType;
	}

	public void setPlateType(PlateType plateType) {
		this.plateType = plateType;
	}

	public Map<String, Map<String, Boolean>> getVals() {
		return vals;
	}

	public void setVals(Map<String, Map<String, Boolean>> vals) {
		this.vals = vals;
	}

	public List<Map<String, Map<String, Boolean>>> getValLst() {
		return valLst;
	}

	public void setValLst(List<Map<String, Map<String, Boolean>>> valLst) {
		this.valLst = valLst;
	}

	public Map<String, String> getRows() {
		return rows;
	}

	public void setRows(Map<String, String> rows) {
		this.rows = rows;
	}

	public Map<String, String> getCols() {
		return cols;
	}

	public void setCols(Map<String, String> cols) {
		this.cols = cols;
	}
	
	
	
}
