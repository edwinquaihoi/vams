package au.com.csl.vams.dao.relational;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IAlgorithmDao;
import au.com.csl.vams.dao.relational.repository.AlgorithmRepository;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.model.relational.AlgorithmType;

@Dao
public class AlgorithmDao extends AbstractDao<Algorithm, String, AlgorithmRepository> implements IAlgorithmDao{
	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(AlgorithmRepository.class));
	}
	
	
	@Override
	public List<Algorithm> findByNameLike(String algName) {
		return getRepository().findByNameLike(algName);
	}
}
