package au.com.csl.vams.dao;

import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.dao.relational.repository.SampleRepository;
import au.com.csl.vams.model.relational.Sample;
import au.com.csl.vams.scaffold.IDao;

@NoRepositoryBean
public interface ISampleDao extends IDao<Sample, String, SampleRepository>, SampleRepository{
}
