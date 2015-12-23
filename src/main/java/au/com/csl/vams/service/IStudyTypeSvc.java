package au.com.csl.vams.service;

import java.util.List;

import javax.ejb.Local;
import au.com.csl.vams.dao.IStudyTypeDao;
import au.com.csl.vams.dao.relational.repository.StudyTypeRepository;
import au.com.csl.vams.model.relational.StudyType;
import au.com.csl.vams.scaffold.IService;

@Local
public interface IStudyTypeSvc extends IService<StudyType, String, StudyTypeRepository, IStudyTypeDao>{
	public List<StudyType> findByNameLikeOrAlgorithmNameContainingOrPlateTypeNameContaining(String studyTypeName, String algorithm, String plateType); 

}
