package au.com.csl.vams.model.relational;



import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import au.com.csl.vams.scaffold.AbstractMasterEntity;

/**
 * @author chamun
 *
 */
@Entity
public class Study extends AbstractMasterEntity<String> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5080784782382647244L;

	/**
	 * 
	 */
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
		
	private String name;
	
	@OneToOne
	private StudyType studyType;	

	@Transient
    private List<Run> runs; 
		
	private String reason;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

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

	public StudyType getStudyType() {
		return studyType;
	}

	public void setStudyType(StudyType studyType) {
		this.studyType = studyType;
	}

	public List<Run> getRuns() {
		return runs;
	}

	public void setRuns(List<Run> runs) {
		this.runs = runs;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PrePersist
	void createDate() {
		this.createDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
	}

}
