package au.com.csl.vams.model.relational;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import au.com.csl.vams.scaffold.AbstractMasterEntity;

@Entity
public class PlateElementVersion extends AbstractMasterEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long plateId;
	
	private Long plateVerId;
	
	private String plateVerName;
	
	private Integer row;
	
	private Integer column;
	
	private Integer value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlateId() {
		return plateId;
	}

	public void setPlateId(Long plateId) {
		this.plateId = plateId;
	}

	public Long getPlateVerId() {
		return plateVerId;
	}

	public void setPlateVerId(Long plateVerId) {
		this.plateVerId = plateVerId;
	}

	public String getPlateVerName() {
		return plateVerName;
	}

	public void setPlateVerName(String plateVerName) {
		this.plateVerName = plateVerName;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String getSearchResultInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
