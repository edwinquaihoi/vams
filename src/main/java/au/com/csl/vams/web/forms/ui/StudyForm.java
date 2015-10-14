package au.com.csl.vams.web.forms.ui;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IStudySvc;
import au.com.csl.vams.utils.PageDetails;
import au.com.csl.vams.web.forms.Mode;
import au.com.csl.vams.dao.relational.AbstractDao;
import au.com.csl.vams.model.relational.Run;



@ManagedBean(name = "studyForm")
@ViewScoped
public class StudyForm  extends AbstractMaintenanceForm<String, Study>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(StudyForm.class); 
	@EJB
	private IStudySvc studySvc;
	
	public IStudySvc getStudySvc() {
		return studySvc;
	}

	public void setStudySvc(IStudySvc studySvc) {
		this.studySvc = studySvc;
	}
	
	
	@Override
	public Study getNewOne() {
		return new Study();
	}

	@Override
	public String getEntityBusinessName() {
		return "study";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public IService getService() {
		return studySvc;
	}

	@Override
	public List<Study> getDefaultSearchResults() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
