package au.com.csl.vams.dao.relational.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.model.relational.AlgorithmType;

@NoRepositoryBean
@Repo
public interface AlgorithmTypeRepository extends JpaRepository<AlgorithmType, String>{
	AlgorithmType findByName(String name);
	List<AlgorithmType> findByNameLike(String name);
}
