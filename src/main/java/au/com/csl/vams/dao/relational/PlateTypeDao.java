package au.com.csl.vams.dao.relational;

import javax.annotation.PostConstruct;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IPlateTypeDao;
import au.com.csl.vams.dao.relational.repository.PlateTypeRepository;
import au.com.csl.vams.model.relational.PlateType;

@Dao
public class PlateTypeDao  extends AbstractDao<PlateType, String, PlateTypeRepository> implements IPlateTypeDao{

	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(PlateTypeRepository.class));
	}
}
