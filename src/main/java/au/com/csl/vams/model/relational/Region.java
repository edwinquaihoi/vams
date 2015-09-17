package au.com.csl.vams.model.relational;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region {
	@Id
	private String name;

}
