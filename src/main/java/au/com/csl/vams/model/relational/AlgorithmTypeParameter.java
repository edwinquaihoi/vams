package au.com.csl.vams.model.relational;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import au.com.csl.vams.scaffold.AbstractMasterEntity;

@Entity
public class AlgorithmTypeParameter extends AbstractMasterEntity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4326008064814325231L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
		
	private String name;
	
	private String description;
	
	private String type;
	
	private String algorithmTypeId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getAlgorithmTypeId() {
		return algorithmTypeId;
	}

	public void setAlgorithmTypeId(String algorithmTypeId) {
		this.algorithmTypeId = algorithmTypeId;
	}

	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean equals(Object obj) {
        if(!(obj instanceof AlgorithmTypeParameter))
            return false;
         
        AlgorithmTypeParameter algtypeparam = (AlgorithmTypeParameter) obj;
         
        return (algtypeparam.getName() != null && algtypeparam.getName().equals(name)) && (algtypeparam.getDescription() != null && algtypeparam.getDescription().equals(description));
    }
	
	public int hashCode() {
        int hash = 1;
        if(name != null)
            hash = hash * 31 + name.hashCode();
         
        if(description != null)
            hash = hash * 29 + description.hashCode();
 
        return hash;
    }

}
