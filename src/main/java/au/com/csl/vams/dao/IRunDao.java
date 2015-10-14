package au.com.csl.vams.dao;

import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.scaffold.IDao;

import org.springframework.data.repository.NoRepositoryBean;

import au.com.csl.vams.dao.relational.repository.RunRepository;

@NoRepositoryBean
public interface IRunDao extends IDao<Run,String,RunRepository>, RunRepository{
}
