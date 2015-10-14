package au.com.csl.vams.service.impl;

import javax.ejb.EJB;
import org.junit.Test;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.service.IPlateSvc;
import au.com.csl.vams.service.IRunSvc;
import au.com.csl.vams.service.IStudySvc;
import au.com.csl.vams.service.ServiceTests;


public class RunSvcTest extends ServiceTests{
	
	@EJB(name="RunSvcLocal")
	private IRunSvc runSvc;
	
	@EJB(name="StudySvcLocal")
	private IStudySvc studySvc;
	
	@EJB(name="PlateSvcLocal")
	private IPlateSvc plateSvc;
	
	
	//@Test
	public void testSaveRun() {

		Run run = new Run();
		// assumption: get and set study info, at present hardcoded

		Study study = studySvc.getById("1");
		run.setStudy(study);

		// create plate and set it to run
		Plate plate = new Plate();
		plate.setPlateName("PlateName1");
		plate.setRun(run);
		plateSvc.create(plate);

		runSvc.create(run);

	}

}
