package au.com.csl.vams.service.impl;

import javax.ejb.EJB;
import org.junit.Test;
import au.com.csl.vams.service.IPlateSvc;
import au.com.csl.vams.service.ServiceTests;


public class PlateSvcTest extends ServiceTests{
	
	@EJB(name="PlateSvcLocal")
	private IPlateSvc plateSvc;
	
	//@Test
	public void testSavePlate()
	{}
}
