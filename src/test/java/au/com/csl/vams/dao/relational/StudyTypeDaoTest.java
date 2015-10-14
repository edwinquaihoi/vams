package au.com.csl.vams.dao.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IStudyTypeDao;
import au.com.csl.vams.dao.RelationalTests;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.model.relational.PlateType;
import au.com.csl.vams.model.relational.StudyType;


public class StudyTypeDaoTest extends RelationalTests{
	@Inject
	@Dao
	IStudyTypeDao dao;
			
	//@Test
	public  void saveStudyType()
	{
		
		StudyType studyType= new StudyType();
		studyType.setName("StudyType1");
			
		Algorithm alg=new Algorithm();
		alg.setName("AlgorithmOne");
		
		
		List<Algorithm> algLst= new ArrayList<Algorithm>();
		algLst.add(alg);
		
		studyType.setAlgorithms(algLst);
				
		PlateType plateType=new PlateType();
		plateType.setName("PlateTypeOne");
		
		
		List<PlateType> plateTypeLst= new ArrayList<PlateType>();
		plateTypeLst.add(plateType);
		
		studyType.setPlateTypes(plateTypeLst);
											
		StudyType studyTypeNew=dao.saveAndFlush(studyType);
		
		List<StudyType> studies = dao.findAll();
		/*assertNotNull(studies.get(0).getAlgorithms().get(0).getStudyType()); 
		assertEquals(studies.get(0).getAlgorithms().get(0).getStudyType().getId(), studyTypeNew.getId());
		
		assertNotNull(studies.get(0).getPlateTypes().get(0).getStudyType()); 
		assertEquals(studies.get(0).getPlateTypes().get(0).getStudyType().getId(), studyTypeNew.getId());
							*/
	}
	
	
	
}
