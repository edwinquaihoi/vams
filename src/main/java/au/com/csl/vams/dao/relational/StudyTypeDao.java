package au.com.csl.vams.dao.relational;



import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IStudyTypeDao;
import au.com.csl.vams.dao.relational.repository.StudyTypeRepository;
import au.com.csl.vams.model.relational.StudyType;

@Dao
public class StudyTypeDao extends AbstractDao<StudyType, String, StudyTypeRepository> implements IStudyTypeDao{
	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(StudyTypeRepository.class));
	}
	
	@Override
	public StudyType findByName(String name) {
		return getRepository().findByName(name);
	}
	
	@Override
	public List<StudyType> findByNameLikeOrAlgorithmNameContainingOrPlateTypeNameContaining(String studyTypeName, String algorithm, String plateType) {
		return getRepository().findByNameLikeOrAlgorithmNameContainingOrPlateTypeNameContaining(studyTypeName, algorithm, plateType);
	}


}
