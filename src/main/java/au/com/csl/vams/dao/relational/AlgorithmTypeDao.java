package au.com.csl.vams.dao.relational;


import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IAlgorithmTypeDao;
import au.com.csl.vams.dao.relational.repository.AlgorithmTypeRepository;
import au.com.csl.vams.model.relational.AlgorithmType;

@Dao
public class AlgorithmTypeDao extends AbstractDao<AlgorithmType, String, AlgorithmTypeRepository>
		implements IAlgorithmTypeDao {

	@Override
	public AlgorithmType findByName(String name) {
		return getRepository().findByName(name);
	}

	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(AlgorithmTypeRepository.class));
	}
	
	@Override
	public List<AlgorithmType> findByNameLike(String algName) {
		return getRepository().findByNameLike(algName);
	}

}
