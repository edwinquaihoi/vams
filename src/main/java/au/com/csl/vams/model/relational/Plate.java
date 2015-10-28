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

/**
 * @author chamun
 *
 */

@Entity
public class Plate extends AbstractMasterEntity<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
		
	private String name;
	
	@ManyToOne
	private Run run;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "PLATE_ID")
    private List<PlateElement> plateElmns;
	
	/*@OneToOne
	private Sample sample;*/
		
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

	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
		this.run = run;
	}

	public List<PlateElement> getPlateElmns() {
		return plateElmns;
	}

	public void setPlateElmns(List<PlateElement> plateElmns) {
		this.plateElmns = plateElmns;
	}
						
	/*public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample;
	}*/
	
	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
