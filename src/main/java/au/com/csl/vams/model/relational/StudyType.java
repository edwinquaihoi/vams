package au.com.csl.vams.model.relational;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import au.com.csl.vams.scaffold.AbstractMasterEntity;

/**
 * @author chamun
 *
 */
@Entity
public class StudyType extends AbstractMasterEntity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3501791258520473967L;

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
		
	private String name;
			
	@OneToOne
	private Algorithm algorithm;
	
	@OneToOne
	private PlateType plateType;
		
	public PlateType getPlateType() {
		return plateType;
	}

	public void setPlateType(PlateType plateType) {
		this.plateType = plateType;
	}

	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

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
		
	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "StudyType [id=" + id + ", name=" + name + "]";
	}
	
	
}
