package au.com.csl.vams.dao;

import org.springframework.data.repository.NoRepositoryBean;
import au.com.csl.vams.dao.relational.repository.StudyTypeRepository;
import au.com.csl.vams.model.relational.StudyType;
import au.com.csl.vams.scaffold.IDao;

@NoRepositoryBean
public interface IStudyTypeDao extends IDao<StudyType, String,StudyTypeRepository>, StudyTypeRepository{

}
