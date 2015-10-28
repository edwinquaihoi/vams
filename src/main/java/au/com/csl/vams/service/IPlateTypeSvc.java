package au.com.csl.vams.service;

import javax.ejb.Local;
import au.com.csl.vams.dao.IPlateTypeDao;
import au.com.csl.vams.dao.relational.repository.PlateTypeRepository;
import au.com.csl.vams.model.relational.PlateType;
import au.com.csl.vams.scaffold.IService;

@Local
public interface IPlateTypeSvc extends IService<PlateType, String, PlateTypeRepository, IPlateTypeDao>{

}
