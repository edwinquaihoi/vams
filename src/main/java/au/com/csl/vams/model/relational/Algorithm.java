package au.com.csl.vams.model.relational;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import au.com.csl.vams.scaffold.AbstractMasterEntity;

@Entity
public class Algorithm extends AbstractMasterEntity<String>{
	
private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;

	private String name;

	@JoinColumn(name = "ALGTYPE")
	@ManyToOne
	private AlgorithmType algType;
		
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "ALGORITHM_ID")
    private List<AlgorithmParameter> parameters;

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

	public AlgorithmType getAlgType() {
		return algType;
	}

	public void setAlgType(AlgorithmType algType) {
		this.algType = algType;
	}
	
	public List<AlgorithmParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<AlgorithmParameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
