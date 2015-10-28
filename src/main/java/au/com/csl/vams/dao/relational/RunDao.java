package au.com.csl.vams.dao.relational;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IRunDao;
import au.com.csl.vams.dao.relational.repository.RunRepository;
import au.com.csl.vams.model.relational.Run;

@Dao
public class RunDao extends AbstractDao<Run, String, RunRepository> implements IRunDao{
	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(RunRepository.class));
	}

	@Override
	public List<Run> findByStudyId(String p_id) {
		return getRepository().findByStudyId(p_id);
	}

	@Override
	public List<Run> findByIdContainingAndStudyNameContaining(String p_id, String p_name) {
		return getRepository().findByIdContainingAndStudyNameContaining(p_id, p_name);
	}

}
