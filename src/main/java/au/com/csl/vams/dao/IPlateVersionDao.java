package au.com.csl.vams.dao;

import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.dao.relational.repository.PlateVersionRepository;
import au.com.csl.vams.model.relational.PlateVersion;
import au.com.csl.vams.scaffold.IDao;

@NoRepositoryBean
public interface IPlateVersionDao extends IDao<PlateVersion, String, PlateVersionRepository>, PlateVersionRepository{

}
