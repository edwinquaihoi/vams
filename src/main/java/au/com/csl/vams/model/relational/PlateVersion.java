package au.com.csl.vams.model.relational;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import au.com.csl.vams.scaffold.AbstractMasterEntity;

/**
 * @author chamun
 *
 */
@Entity
public class PlateVersion extends AbstractMasterEntity<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3239461101660694089L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
			
	private String plateId;
	
	@Lob
	private String plateElmns;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlateId() {
		return plateId;
	}

	public void setPlateId(String plateId) {
		this.plateId = plateId;
	}
	
	public String getPlateElmns() {
		return plateElmns;
	}

	public void setPlateElmns(String plateElmns) {
		this.plateElmns = plateElmns;
	}

	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
