package au.com.csl.vams.model.relational;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import au.com.csl.vams.scaffold.AbstractMasterEntity;
import java.util.List;

/**
 * @author chamun
 *
 */
@Entity
public class StudyType extends AbstractMasterEntity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	
	
	private String name;
		
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="STUDY_TYPE_ID")
	private List<Algorithm> algorithms;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="STUDY_TYPE_ID")
    private List<PlateType> plateTypes;


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
	
	public List<Algorithm> getAlgorithms() {
		return algorithms;
	}

	public void setAlgorithms(List<Algorithm> algorithms) {
		this.algorithms = algorithms;
	}
	
	public List<PlateType> getPlateTypes() {
		return plateTypes;
	}

	public void setPlateTypes(List<PlateType> plateTypes) {
		this.plateTypes = plateTypes;
	}
	
	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "StudyType [id=" + id + ", name=" + name + ", algorithms=" + algorithms + "]";
	}
	
	
}
