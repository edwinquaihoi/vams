package au.com.csl.vams.dao.relational.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.model.relational.Plate;

@NoRepositoryBean
@Repo
public interface PlateRepository extends JpaRepository<Plate, String> {
	public List<Plate> findByRunId(String id);
}
