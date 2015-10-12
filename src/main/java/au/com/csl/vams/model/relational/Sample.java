package au.com.csl.vams.model.relational;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import au.com.csl.vams.scaffold.AbstractMasterEntity;

/**
 * @author chamun
 *
 */
@Entity
public class Sample extends AbstractMasterEntity<String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
		
	private String sampleName;
		
	private Integer initialDil;
		
	private Integer dilInterval;
	
	private Integer volTested;
	
	private String calcLOD;
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public Integer getInitialDil() {
		return initialDil;
	}

	public void setInitialDil(Integer initialDil) {
		this.initialDil = initialDil;
	}

	public Integer getDilInterval() {
		return dilInterval;
	}

	public void setDilIntervals(Integer dilInterval) {
		this.dilInterval = dilInterval;
	}

	public Integer getVolTested() {
		return volTested;
	}

	public void setVolTested(Integer volTested) {
		this.volTested = volTested;
	}

	public String getCalcLOD() {
		return calcLOD;
	}

	public void setCalcLOD(String calcLOD) {
		this.calcLOD = calcLOD;
	}
	
	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
