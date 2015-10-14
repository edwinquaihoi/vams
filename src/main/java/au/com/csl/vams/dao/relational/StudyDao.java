package au.com.csl.vams.dao.relational;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IStudyDao;
import au.com.csl.vams.dao.relational.repository.StudyRepository;
import au.com.csl.vams.model.relational.Study;

@Dao
public class StudyDao extends AbstractDao<Study, String, StudyRepository> implements IStudyDao{
	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(StudyRepository.class));
	}

	@Override
	public List<Study> findByStudyNameContainingOrIdContaining(String p_name, String p_id) {
		return getRepository().findByStudyNameContainingOrIdContaining(p_name, p_id);
	}

	

	
}
