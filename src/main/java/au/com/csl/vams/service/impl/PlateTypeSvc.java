package au.com.csl.vams.service.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IPlateTypeDao;
import au.com.csl.vams.service.IPlateTypeSvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PlateTypeSvc implements IPlateTypeSvc {
	
	@Inject
	@Dao
	private IPlateTypeDao dao;

	public IPlateTypeDao getDao() {
		return dao;
	}

	public void setDao(IPlateTypeDao dao) {
		this.dao = dao;
	}
	
}
