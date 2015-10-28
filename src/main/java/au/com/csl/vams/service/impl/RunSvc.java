package au.com.csl.vams.service.impl;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IRunDao;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.service.IRunSvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RunSvc implements IRunSvc {
		
	@Inject
	@Dao
	private IRunDao dao;
	
	public IRunDao getDao() {
		return dao;
	}

	public void setDao(IRunDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Run> findByStudyId(String p_id) {
		return getDao().findByStudyId(p_id);
	}

	@Override
	public List<Run> findByIdContainingAndStudyNameContaining(String p_id, String p_name) {
		return getDao().findByIdContainingAndStudyNameContaining(p_id, p_name);
	}

}
