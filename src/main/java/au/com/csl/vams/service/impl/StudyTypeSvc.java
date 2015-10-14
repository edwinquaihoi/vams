package au.com.csl.vams.service.impl;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IStudyTypeDao;
import au.com.csl.vams.model.relational.StudyType;
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

	@Override
	public StudyType getById(String pId) {
		return getDao().findOne(pId);
	}

	@Override
	public StudyType create(StudyType pEntity) {
		return getDao().save(pEntity);
	}

	@Override
	public StudyType update(StudyType pEntity) {
		return getDao().save(pEntity);

	}

	@Override
	public void delete(StudyType pEntity) {
		getDao().delete(pEntity);

	}

	@Override
	public List<StudyType> getAll() {
		return getDao().findAll();
	}

}
