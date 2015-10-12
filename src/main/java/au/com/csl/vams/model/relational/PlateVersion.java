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
public class PlateVersion extends AbstractMasterEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String plateVerName;
	
	private Plate plate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlateVerName() {
		return plateVerName;
	}

	public void setPlateVerName(String plateVerName) {
		this.plateVerName = plateVerName;
	}
	
	public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
