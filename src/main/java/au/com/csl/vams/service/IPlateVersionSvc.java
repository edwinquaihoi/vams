package au.com.csl.vams.service;

import java.util.List;
import javax.ejb.Local;
import au.com.csl.vams.dao.IPlateVersionDao;
import au.com.csl.vams.dao.relational.repository.PlateVersionRepository;
import au.com.csl.vams.model.relational.PlateVersion;
import au.com.csl.vams.scaffold.IService;

@Local
public interface IPlateVersionSvc extends IService<PlateVersion, String, PlateVersionRepository, IPlateVersionDao> {
	public List<PlateVersion> findByPlateId(String id);
}
