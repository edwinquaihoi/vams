package au.com.csl.vams.dao.relational;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IStudyDao;
import au.com.csl.vams.dao.IStudyTypeDao;
import au.com.csl.vams.dao.RelationalTests;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.model.relational.StudyType;


public class StudyDaoTest extends RelationalTests {
	
	@Inject
	@Dao
	IStudyDao dao;
	
	@Inject
	@Dao
	IStudyTypeDao studyTypeDao;
				
	@Test
	public void saveStudyTest()
	{
		try {
			
			Study study = new Study();
			study.setName("study1");
			StudyType st1 = new StudyType();
			st1.setName("st1");
			studyTypeDao.saveAndFlush(st1);
			study.setStudyType(st1);
			//study.setCreateDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
			dao.saveAndFlush(study);
			
			Study study2 = new Study();
			study2.setName("study2");
			//study2.setCreateDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
			StudyType st2 = new StudyType();
			st2.setName("st2");
			studyTypeDao.saveAndFlush(st2);
			study2.setStudyType(st2);
			dao.saveAndFlush(study2);
			
			//assertEquals(1, dao.count());
			System.out.println(dao.findAll());
			StudyType stt= new StudyType();
			stt.setName("st1");
			List<Study> studyLst=dao.findByNameLikeOrIdContainingOrStudyTypeNameContaining("%study1%", "null","st1");
			System.out.println("studyLst***"+studyLst);
			//assertEquals(1, studyLst.size());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	

}
