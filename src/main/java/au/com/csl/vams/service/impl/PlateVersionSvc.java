package au.com.csl.vams.service.impl;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IPlateVersionDao;
import au.com.csl.vams.model.relational.PlateVersion;
import au.com.csl.vams.service.IPlateVersionSvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PlateVersionSvc implements IPlateVersionSvc {

	@Inject
	@Dao
	private IPlateVersionDao dao;

	public IPlateVersionDao getDao() {
		return dao;
	}

	public void setDao(IPlateVersionDao dao) {
		this.dao = dao;
	}

	@Override
	public List<PlateVersion> findByPlateId(String id) {
		return dao.findByPlateId(id);
	}


}
