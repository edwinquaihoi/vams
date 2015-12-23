package au.com.csl.vams.model.relational;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import au.com.csl.vams.scaffold.AbstractMasterEntity;

@Entity
public class AlgorithmType extends AbstractMasterEntity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6425586542456619111L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
		
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "ALGORITHMTYPE_ID")
    private List<AlgorithmTypeParameter> parameters;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public List<AlgorithmTypeParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<AlgorithmTypeParameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
