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
			study.setStudyName("study1");
			study.setCreateDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
			dao.saveAndFlush(study);
			
			assertEquals(1, dao.count());
			List<Study> studyLst=dao.findByStudyNameContainingOrIdContaining("stu", "");
			assertEquals(1, studyLst.size());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	

}
