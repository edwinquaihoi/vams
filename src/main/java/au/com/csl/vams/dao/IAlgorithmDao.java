package au.com.csl.vams.dao;



import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.dao.relational.repository.AlgorithmRepository;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.scaffold.IDao;

@NoRepositoryBean
public interface IAlgorithmDao extends IDao<Algorithm, String, AlgorithmRepository>,AlgorithmRepository {
}
