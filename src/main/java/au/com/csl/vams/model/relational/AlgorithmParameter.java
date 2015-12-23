package au.com.csl.vams.model.relational;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import au.com.csl.vams.scaffold.AbstractMasterEntity;

@Entity
public class AlgorithmParameter extends AbstractMasterEntity<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7180455258701904561L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
		
	private String name;
	
	private String value;
	
	private String type;
			
	private String algorithmId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
			
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlgorithmId() {
		return algorithmId;
	}

	public void setAlgorithmId(String algorithmId) {
		this.algorithmId = algorithmId;
	}
		
	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean equals(Object obj) {
        if(!(obj instanceof AlgorithmParameter))
            return false;
         
        AlgorithmParameter algtypeparam = (AlgorithmParameter) obj;
         
        return (algtypeparam.getName() != null && algtypeparam.getName().equals(name)) && (algtypeparam.getValue() != null && algtypeparam.getValue().equals(value));
    }
	
	public int hashCode() {
        int hash = 1;
        if(name != null)
            hash = hash * 31 + name.hashCode();
         
        if(value != null)
            hash = hash * 29 + value.hashCode();
 
        return hash;
    }
	
}
