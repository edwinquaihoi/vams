package au.com.csl.vams.service.impl;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IStudyDao;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.service.IStudySvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class StudySvc implements IStudySvc{

	@Inject
	@Dao
	private IStudyDao dao;

	public IStudyDao getDao() {
		return dao;
	}

	public void setDao(IStudyDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Study getById(String pId) {
		return getDao().findOne(pId);
	}
	
	@Override
	public Study create(Study pEntity) {
		return getDao().saveAndFlush(pEntity);
	}
	
	@Override
	public Study update(Study pEntity) {
		return getDao().saveAndFlush(pEntity);
	}

	@Override
	public void delete(Study pEntity) {
		getDao().delete(pEntity);
	}
	
	@Override
	public List<Study> getAll() {
		return getDao().findAll();
	}

	@Override
	public List<Study> findByStudyNameContainingOrIdContaining(String studyName, String studyId) {
		return getDao().findByStudyNameContainingOrIdContaining(studyName, studyId);
	}

	
	
	
	
}
