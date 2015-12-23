package au.com.csl.vams.model.relational;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Run extends AbstractMasterEntity<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
			
	@ManyToOne
	private Study study;
			
	@Transient
    private List<Plate> plates;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
				
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Plate> getPlates() {
		return plates;
	}

	public void setPlates(List<Plate> plates) {
		this.plates = plates;
	}
		
	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
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
		
	public long getPlatesCount() {
		if (getPlates() != null) {
			return getPlates().size();
		} else {
			return 0;
		}
	}
	
	// Return formatted create date
	public String getFormattedCreateDate() {
		String result = new SimpleDateFormat("dd-MMM-yy HH:mm").format(getCreateDate());
		return result;
	}

}
