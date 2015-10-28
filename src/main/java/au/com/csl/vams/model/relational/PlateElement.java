package au.com.csl.vams.model.relational;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import au.com.csl.vams.scaffold.AbstractMasterEntity;

/**
 * @author chamun
 *
 */

@Entity
public class PlateElement extends AbstractMasterEntity<String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	
	private String row;
	
	private String column;
	
	private String value;
	
	private String plateId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPlateId() {
		return plateId;
	}

	public void setPlateId(String plateId) {
		this.plateId = plateId;
	}

	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
