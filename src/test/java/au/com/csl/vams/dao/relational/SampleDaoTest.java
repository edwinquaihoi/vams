package au.com.csl.vams.dao.relational;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.ISampleDao;
import au.com.csl.vams.dao.RelationalTests;
import au.com.csl.vams.model.relational.Sample;
import org.junit.Test;

public class SampleDaoTest extends RelationalTests {
	

	@Inject
	@Dao
	ISampleDao dao;
	
	@Test
	public void Test(){
		/*Sample sample = new Sample();
		sample.setSampleName("bloodSample1");
		sample.setInitialDil(1);
		
		sample.setDilIntervals(12);
		sample.setVolTested(50);
		dao.saveAndFlush(sample);
		
		List<Sample> s=dao.findAll();
		assertNotNull(s);
		System.out.println(s.get(0).getSampleName());
		assertEquals("bloodSample1", s.get(0).getSampleName());*/
		
	}

}
