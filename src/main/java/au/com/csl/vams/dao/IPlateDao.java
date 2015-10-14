package au.com.csl.vams.dao;


import org.springframework.data.repository.NoRepositoryBean;

import au.com.csl.vams.dao.relational.repository.PlateRepository;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.scaffold.IDao;

@NoRepositoryBean
public interface IPlateDao extends IDao<Plate, String, PlateRepository> , PlateRepository{
	
}
