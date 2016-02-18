package au.com.csl.vams.dao.relational;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import au.com.csl.vams.dao.IPlateDao;
import au.com.csl.vams.dao.IPlateTypeDao;
import au.com.csl.vams.dao.IRunDao;
import au.com.csl.vams.dao.RelationalTests;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.PlateElement;
import au.com.csl.vams.model.relational.PlateType;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.dao.Dao;

public class PlateDaoTest extends RelationalTests {
	
	@Inject
	@Dao
	IPlateDao dao;
	
	@Inject
	@Dao
	IRunDao runDao;
	
	@Inject
	@Dao
	IPlateTypeDao ptDao;
	
	
	
	
	@Test
	public void testSavePlate()
	{
		Run run = new Run();
		runDao.saveAndFlush(run);
		
		PlateType pt = new PlateType();
		pt.setName("5*5");
		ptDao.saveAndFlush(pt);
		
		Plate plate = new Plate();
		plate.setName("plateOne");
		plate.setPlateType(pt);
		plate.setRun(run);
		
		PlateElement plateElm = new PlateElement();
		plateElm.setRow("1");
		plateElm.setColumn("1");
		plateElm.setValue("0");
		plateElm.setPlateId(plate.getId());
		
		List<PlateElement> plateElmLst = new ArrayList<PlateElement>();
		plateElmLst.add(plateElm);
		plate.setPlateElmns(plateElmLst);
		
		
		
		
				
		dao.saveAndFlush(plate);
		List<Plate> pLst=dao.findAll();
		List<Plate>p=dao.findByRunId("1");
		
		assertEquals(1, p.get(0).getPlateElmns().size());
		assertEquals(1, pLst.get(0).getPlateElmns().size());
				
	}
	
	//@Test
	public void getPlatesByRunId()
	{
		List<Plate> plateLst=dao.findByRunId("1");
		assertEquals("1", plateLst.size());
	}
	
	
	

}
