package au.com.csl.vams.service;

import java.util.List;

import javax.ejb.Local;
import au.com.csl.vams.dao.IStudyDao;
import au.com.csl.vams.dao.relational.repository.StudyRepository;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.scaffold.IService;

@Local
public interface IStudySvc extends IService<Study, String, StudyRepository, IStudyDao>{
	
	List<Study> findByStudyNameContainingOrIdContaining(String studyName, String studyId);

}
