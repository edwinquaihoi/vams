package au.com.csl.vams.web.forms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import au.com.csl.vams.model.relational.PageDetails;

/**
 * This bean is used to drive the application main menu system.
 * 
 * @author devops
 *
 */
@ManagedBean
public class NavigationBean {

	// FIXME this bean maybe redundant as the actual form that we are navigating to should have the knowledge on how to
	// setup the sessionModel correctly.
	
	@SuppressWarnings("rawtypes")
	@ManagedProperty("#{sessionModel}")
	private SessionModel sessionModel;
		
	public void dashboard() {
		getSessionModel().addPage(new PageDetails("dashboard.xhtml", null, null));
		getSessionModel().setContent("dashboard.xhtml");
	}
	
	public void setup() {
		getSessionModel().addPage(new PageDetails("ui/setup.xhtml", null, null));
		getSessionModel().setContent("ui/setup.xhtml");
	}
		
	public void manageAssets() {
		getSessionModel().addPage(new PageDetails("ui/asset/manageAssets.xhtml", null, null));
		getSessionModel().setContent("ui/asset/manageAssets.xhtml");
	}
	
	public void home() {
		getSessionModel().addPage(new PageDetails("home.xhtml", null, null));
		getSessionModel().setContent("home.xhtml");	
	}
	
	public void prodserv() {
		getSessionModel().addPage(new PageDetails("products-and-services.xhtml", null, null));
		getSessionModel().setContent("products-and-services.xhtml");
	}
	
	public void login() {
		getSessionModel().setContent("login.xhtml");
	}

	public SessionModel getSessionModel() {
		return sessionModel;
	}
	
	public void setSessionModel(SessionModel sessionModel) {
		this.sessionModel = sessionModel;
	}
}
