package au.com.csl.vams.model.relational;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import au.com.csl.vams.scaffold.AbstractMasterEntity;

@Entity
public class Algorithm extends AbstractMasterEntity<String>{
	
private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	
	private String name;
	
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

}
