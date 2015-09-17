package au.com.csl.vams.model.relational;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import au.com.csl.vams.model.Master;

@Master
@Entity
public class Project {

	@Id
	private long id;
	
	private String name;
	
	// job type
	
	//@ManyToOne
	//private Group group;

	@OneToMany
	private List<Group> groups;

	@ManyToOne
	private Branch branch;
	
	@ManyToOne
	private Section section;
	
	@ManyToOne
	private Team team;
	
	@Temporal(TemporalType.DATE)
	private Date added;
	
	@ManyToOne
	private AppUser addedBy;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Program program;
	
	@ManyToOne
	private Priority priority;
	
	@ManyToOne
	private Scheme scheme;
	
	@ManyToOne
	private Region region;
	
	@ManyToOne
	private Division division;
	
	// driver
	
	// gateway
	
	// tasks
	
	@Version
	private int version;
}
