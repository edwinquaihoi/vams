package au.com.csl.vams.dao.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IAlgorithmDao;
import au.com.csl.vams.dao.IPlateTypeDao;
import au.com.csl.vams.dao.IStudyTypeDao;
import au.com.csl.vams.dao.RelationalTests;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.model.relational.PlateType;
import au.com.csl.vams.model.relational.StudyType;


public class StudyTypeDaoTest extends RelationalTests{
	@Inject
	@Dao
	IStudyTypeDao dao;
	
	@Inject
	@Dao
	IAlgorithmDao algdao;
	
	@Inject
	@Dao
	IPlateTypeDao platetypedao;
			
	@Test
	public  void saveStudyType()
	{
		
		StudyType studyType= new StudyType();
		studyType.setName("StudyType1");
		
		Algorithm alg = new Algorithm();
		alg.setName("alg1");
		algdao.saveAndFlush(alg);
		
		studyType.setAlgorithm(alg);
		
		PlateType plateType = new PlateType();
		plateType.setName("platetype1");
		platetypedao.saveAndFlush(plateType);
		
		studyType.setPlateType(plateType);
		
		StudyType studyTypeNew=dao.saveAndFlush(studyType);
		
		List<StudyType> studies = dao.findAll();
	
	}
	
	
	
}
