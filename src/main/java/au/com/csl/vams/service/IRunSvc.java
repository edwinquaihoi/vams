package au.com.csl.vams.service;

import java.util.List;

import javax.ejb.Local;
import au.com.csl.vams.dao.IRunDao;
import au.com.csl.vams.dao.relational.repository.RunRepository;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.scaffold.IService;

@Local
public interface IRunSvc extends IService<Run, String, RunRepository, IRunDao> {
	List<Run> findByStudyId(String p_id); 
}
