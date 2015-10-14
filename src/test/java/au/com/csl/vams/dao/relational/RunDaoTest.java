package au.com.csl.vams.dao.relational;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.dao.IRunDao;
import au.com.csl.vams.dao.IStudyDao;
import au.com.csl.vams.dao.RelationalTests;

public class RunDaoTest extends RelationalTests{
	
	@Inject
	@Dao
	IRunDao dao;
	
	@Inject
	@Dao
	IStudyDao studyDao;
	
	
	@Test
	public void saveTest()
	{
		Run run = new Run();
		Plate plate = new Plate();
		plate.setPlateName("PlateName1");

		plate.setRun(run);
		List<Plate> plateLst = new ArrayList<Plate>();
		plateLst.add(plate);
		run.setPlates(plateLst);
		
		Study study = new Study();
		study.setStudyName("study1");
		study.setCreateDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		Study studyNew=studyDao.saveAndFlush(study);

		run.setStudy(studyNew);
		
		dao.saveAndFlush(run);
		
		List<Run> runLst=dao.findByStudyId("1");
		assertEquals("study1",runLst.get(0).getStudy().getStudyName());
		
		
	}
	

}