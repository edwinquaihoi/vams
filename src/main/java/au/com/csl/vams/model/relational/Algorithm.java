package au.com.csl.vams.model.relational;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import au.com.csl.vams.scaffold.AbstractMasterEntity;

@Entity
public class Algorithm extends AbstractMasterEntity<Long>{
	
private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	private String studyTypeID;
			
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    		
	public String getStudyTypeID() {
		return studyTypeID;
	}

	public void setStudyTypeID(String studyTypeID) {
		this.studyTypeID = studyTypeID;
	}

	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
