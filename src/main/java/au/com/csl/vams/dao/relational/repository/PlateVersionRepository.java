package au.com.csl.vams.dao.relational.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.model.relational.PlateVersion;

@NoRepositoryBean
@Repo
public interface PlateVersionRepository  extends JpaRepository<PlateVersion, String>{
	
	public List<PlateVersion> findByPlateId(String id);
}
