package au.com.csl.vams.model.relational;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {
	@Id
	private String name;

}
