package au.com.csl.vams.service.impl;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import au.com.csl.vams.model.relational.AppUser;
import au.com.csl.vams.service.IUserSvc;
import au.com.csl.vams.service.ServiceTests;

public class UserSvcTest extends ServiceTests {

	@EJB(name="UserSvcLocal")
	private IUserSvc userSvc;

	//@Test
	public void testCreate() {

		assertNotNull(userSvc);
		
		AppUser u = new AppUser();
		u.setLogin("sanket");
		u.setPassword("passw0rd");

		AppUser savedAcct = userSvc.update(u);
		
		assertNotNull(savedAcct);

	}

	@Test
	public void test() {}
}
