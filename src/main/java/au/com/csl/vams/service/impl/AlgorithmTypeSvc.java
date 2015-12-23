package au.com.csl.vams.service.impl;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IAlgorithmTypeDao;
import au.com.csl.vams.model.relational.AlgorithmType;
import au.com.csl.vams.service.IAlgorithmTypeSvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AlgorithmTypeSvc implements IAlgorithmTypeSvc {

	@Inject
	@Dao
	private IAlgorithmTypeDao dao;

	public IAlgorithmTypeDao getDao() {
		return dao;
	}

	public void setDao(IAlgorithmTypeDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<AlgorithmType> findByNameLike(String algName) {
		return getDao().findByNameLike(algName);
	}	

}
