package au.com.csl.vams.dao;

import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.dao.relational.repository.AlgorithmTypeRepository;
import au.com.csl.vams.model.relational.AlgorithmType;
import au.com.csl.vams.scaffold.IDao;

@NoRepositoryBean
public interface IAlgorithmTypeDao extends IDao<AlgorithmType, String, AlgorithmTypeRepository>, AlgorithmTypeRepository {

}
