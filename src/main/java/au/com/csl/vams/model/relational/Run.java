package au.com.csl.vams.model.relational;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import au.com.csl.vams.scaffold.AbstractMasterEntity;

/**
 * @author chamun
 *
 */
@Entity
public class Run extends AbstractMasterEntity<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
			
	@ManyToOne
	private Study study;
			
	@Transient
    private List<Plate> plates;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
		
	public List<Plate> getPlates() {
		return plates;
	}

	public void setPlates(List<Plate> plates) {
		this.plates = plates;
	}
		
	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}
	
	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
