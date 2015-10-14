package au.com.csl.vams.service.impl;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IPlateDao;
import au.com.csl.vams.dao.ISampleDao;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.model.relational.Sample;
import au.com.csl.vams.service.IPlateSvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PlateSvc implements IPlateSvc {

	@Inject
	@Dao
	private IPlateDao dao;
	
	@Inject
	@Dao
	private ISampleDao sampleDao;


	public IPlateDao getDao() {
		return dao;
	}

	public void setDao(IPlateDao dao) {
		this.dao = dao;
	}
		
	public ISampleDao getSampleDao() {
		return sampleDao;
	}

	public void setSampleDao(ISampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}

	@Override
	public Plate getById(String pId) {
		return getDao().findOne(pId);
	}

	@Override
	public Plate create(Plate pEntity) {
		return getDao().saveAndFlush(pEntity);
	}

	@Override
	public Plate update(Plate pEntity) {
		return getDao().saveAndFlush(pEntity);
	}

	@Override
	public void delete(Plate pEntity) {
		getDao().delete(pEntity);

	}

	@Override
	public List<Plate> getAll() {
		return getDao().findAll();
	}
	
	@Override
	public void calcLargeVol(Sample sample, Plate plate) {
		if (sample != null && plate != null) {
			// TODO calculate LOD and update sample
			sample.setCalcLOD("hardcoded for now");
			getSampleDao().saveAndFlush(sample);
		}

	}
	
	@Override
	public List<Plate> getPlates(Run run) {
		return getDao().findByRunId(run.getId());
	}
}
