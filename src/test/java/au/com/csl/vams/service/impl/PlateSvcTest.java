package au.com.csl.vams.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import org.junit.Test;

import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.PlateElement;
import au.com.csl.vams.model.relational.PlateType;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.service.IPlateSvc;
import au.com.csl.vams.service.IPlateTypeSvc;
import au.com.csl.vams.service.IRunSvc;
import au.com.csl.vams.service.ServiceTests;


public class PlateSvcTest extends ServiceTests{
	
	@EJB(name="PlateSvcLocal")
	private IPlateSvc plateSvc;
	
	@EJB(name="RunSvcLocal")
	private IRunSvc runSvc;
	
	@EJB(name="PlateTypeSvcLocal")
	private IPlateTypeSvc platetypeSvc;
	
	
	
	//@Test
	public void testSavePlate()
	{
		Run run = new Run();
		runSvc.create(run);
		
		PlateType pt = new PlateType();
		pt.setName("5*5");
		platetypeSvc.create(pt);
		
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
						
		plateSvc.create(plate);
	}
}
