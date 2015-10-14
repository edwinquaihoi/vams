package au.com.csl.vams.dao.relational;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import au.com.csl.vams.dao.IPlateDao;
import au.com.csl.vams.dao.RelationalTests;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.PlateElement;
import au.com.csl.vams.model.relational.PlateVersion;
import au.com.csl.vams.dao.Dao;

public class PlateDaoTest extends RelationalTests {
	
	@Inject
	@Dao
	IPlateDao dao;
	
	
	@Test
	public void savePlate()
	{
		Plate plate = new Plate();
		plate.setPlateName("plateOne");
		
		PlateElement plateElm = new PlateElement();
		plateElm.setRow(1);
		plateElm.setColumn(1);
		plateElm.setValue(0);
		
		
		List<PlateElement> plateElmLst = new ArrayList<PlateElement>();
		plateElmLst.add(plateElm);
		plate.setPlateElmns(plateElmLst);
		
		PlateVersion plateVer = new PlateVersion();
		plateVer.setPlateVerName("version 1");
		plateVer.setPlate(plate);
		
		
		List<PlateVersion> plateVerLst = new ArrayList<PlateVersion>();
		plateVerLst.add(plateVer);

		//plate.setRun(run);
		
		Plate plateNew=dao.saveAndFlush(plate);
				
	}
	
	@Test
	public void getPlatesByRunId()
	{
		List<Plate> plateLst=dao.findByRunId("1");
		assertEquals("1", plateLst.size());
	}
	
	
	

}
