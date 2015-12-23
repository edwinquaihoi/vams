package au.com.csl.vams.dao.relational.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.model.relational.StudyType;

@NoRepositoryBean
@Repo
public interface StudyTypeRepository extends JpaRepository<StudyType, String>{
	StudyType findByName(String name);
	List<StudyType> findByNameLikeOrAlgorithmNameContainingOrPlateTypeNameContaining(String studyTypeName, String algorithm, String plateType); 
}
