package au.com.csl.vams.dao.relational;


import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IPlateVersionDao;
import au.com.csl.vams.dao.relational.repository.PlateVersionRepository;
import au.com.csl.vams.model.relational.PlateVersion;

@Dao
public class PlateVersionDao extends AbstractDao<PlateVersion, String, PlateVersionRepository>  implements IPlateVersionDao{

	@Override
	@PostConstruct
	public void init() {
		JpaRepositoryFactory factory = new JpaRepositoryFactory(getEntityManager());
		setRepository(factory.getRepository(PlateVersionRepository.class));
	}
	
	@Override
	public List<PlateVersion> findByPlateId(String id) {
		return getRepository().findByPlateId(id);
		
	}

	
	
}
