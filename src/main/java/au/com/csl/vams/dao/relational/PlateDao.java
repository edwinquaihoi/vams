package au.com.csl.vams.dao.relational;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IPlateDao;
import au.com.csl.vams.dao.relational.repository.PlateRepository;
import au.com.csl.vams.model.relational.Plate;

@Dao
public class PlateDao extends AbstractDao<Plate, String, PlateRepository> implements IPlateDao{
	
	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(PlateRepository.class));
	}

	@Override
	public List<Plate> findByRunId(String id) {
		return getRepository().findByRunId(id);
		
	}

}
