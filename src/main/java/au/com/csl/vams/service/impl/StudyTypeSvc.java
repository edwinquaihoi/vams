package au.com.csl.vams.service.impl;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IStudyTypeDao;
import au.com.csl.vams.service.IStudyTypeSvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class StudyTypeSvc implements IStudyTypeSvc{
	
	@Inject
	@Dao
	private IStudyTypeDao dao;

	public void setDao(IStudyTypeDao dao) {
		this.dao = dao;
	}

	public IStudyTypeDao getDao() {
		return dao;
	}

}
