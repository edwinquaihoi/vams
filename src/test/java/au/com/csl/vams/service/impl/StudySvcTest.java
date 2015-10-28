package au.com.csl.vams.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import org.junit.Test;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.model.relational.PlateType;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.model.relational.StudyType;
import au.com.csl.vams.service.IStudySvc;
import au.com.csl.vams.service.IStudyTypeSvc;
import au.com.csl.vams.service.ServiceTests;


public class StudySvcTest extends ServiceTests {
	
	@EJB(name="StudySvcLocal")
	private IStudySvc studySvc;
	
	@EJB(name="StudyTypeSvcLocal")
	private IStudyTypeSvc studyTypeSvc;
	
	//@Test
	public void testSaveStudy() {
		// assumption 1: study is predefined data
		// assumption 2: studyType, Algorithm, PlateType are predefined data ,
		// load using combobox in study
		
		
		assertNotNull(studySvc);
		
	    Study study = new Study();
		study.setName("Viro1");
		study.setCreateDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

		// create studyType
		StudyType studyType = new StudyType();
		studyType.setName("StudyType1");

		Algorithm alg = new Algorithm();
		alg.setName("AlgorithmOne");


		studyType.setAlgorithm(alg);

		PlateType plateType = new PlateType();
		plateType.setName("PlateTypeOne");

		
		studyType.setPlateType(plateType);
		StudyType st=studyTypeSvc.create(studyType);
		
		study.setStudyType(st);
		Study sd = studySvc.create(study);
		
		assertNotNull(sd);
		

	}
	
	
	@Test
	public void testGetStudy()
	{
		//List<Study> studyLst=studySvc.findByNameContainingOrIdContaining("Vi", "");
		//assertEquals(1, studyLst.size());
	
	}

}
