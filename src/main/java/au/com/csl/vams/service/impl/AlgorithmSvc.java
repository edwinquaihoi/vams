package au.com.csl.vams.service.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IAlgorithmDao;
import au.com.csl.vams.service.IAlgorithmSvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AlgorithmSvc implements IAlgorithmSvc {
	
	@Inject
	@Dao
	private IAlgorithmDao dao;

	public IAlgorithmDao getDao() {
		return dao;
	}

	public void setDao(IAlgorithmDao dao) {
		this.dao = dao;
	}
	
	

}