package au.com.csl.vams.dao.relational.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.model.relational.StudyType;
import au.com.csl.vams.dao.relational.repository.Repo;

@NoRepositoryBean
@Repo
public interface StudyRepository extends JpaRepository<Study, String>{

	List<Study> findByNameLikeOrIdContainingOrStudyTypeNameContaining(String p_name,String p_id,String p_type);
	

}
