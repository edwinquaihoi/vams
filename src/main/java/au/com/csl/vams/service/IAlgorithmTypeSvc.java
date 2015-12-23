package au.com.csl.vams.service;

import java.util.List;
import javax.ejb.Local;
import au.com.csl.vams.dao.IAlgorithmTypeDao;
import au.com.csl.vams.dao.relational.repository.AlgorithmTypeRepository;
import au.com.csl.vams.model.relational.AlgorithmType;
import au.com.csl.vams.scaffold.IService;

@Local
public interface IAlgorithmTypeSvc extends IService<AlgorithmType, String, AlgorithmTypeRepository, IAlgorithmTypeDao> {
	public List<AlgorithmType> findByNameLike(String algName);

}
