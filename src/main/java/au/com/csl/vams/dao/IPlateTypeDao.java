package au.com.csl.vams.dao;

import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.dao.relational.repository.PlateTypeRepository;
import au.com.csl.vams.model.relational.PlateType;
import au.com.csl.vams.scaffold.IDao;

@NoRepositoryBean
public interface IPlateTypeDao  extends IDao<PlateType, String, PlateTypeRepository>{

}
