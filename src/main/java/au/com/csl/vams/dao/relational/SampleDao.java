package au.com.csl.vams.dao.relational;


import javax.annotation.PostConstruct;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.ISampleDao;
import au.com.csl.vams.dao.relational.repository.SampleRepository;
import au.com.csl.vams.model.relational.Sample;

@Dao
public class SampleDao extends AbstractDao<Sample, String, SampleRepository> implements ISampleDao{
	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(SampleRepository.class));
	}
}
