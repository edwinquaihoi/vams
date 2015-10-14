package au.com.csl.vams.dao;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.scaffold.IDao;
import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.dao.relational.repository.StudyRepository;

@NoRepositoryBean
public interface IStudyDao extends IDao<Study, String, StudyRepository> , StudyRepository{
}
