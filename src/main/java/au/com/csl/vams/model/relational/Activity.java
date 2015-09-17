package au.com.csl.vams.model.relational;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Activity {
	
	@Id
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date forecastStart;
	
	@Temporal(TemporalType.DATE)
	private Date forecastEnd;

	@Temporal(TemporalType.DATE)
	private Date plannedStart;

	@Temporal(TemporalType.DATE)
	private Date plannedEnd;

	@Temporal(TemporalType.DATE)
	private Date actualStart;

	@Temporal(TemporalType.DATE)
	private Date actualEnd;
	
	private String context;
	
	private List<String> links;
}
