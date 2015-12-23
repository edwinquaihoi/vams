package au.com.csl.vams.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.model.relational.AlgorithmParameter;
import au.com.csl.vams.scaffold.ICalculatePlugin;
import au.com.csl.vams.scaffold.PluginFactory;

public class PluginTest{
	
	@Test
	public void test()
	{
		Algorithm algorithm = new Algorithm();
		AlgorithmParameter param1 = new AlgorithmParameter();
		param1.setName("a");
		param1.setType("String");
		param1.setValue("10");
		
		AlgorithmParameter param2 = new AlgorithmParameter();
		param2.setName("a");
		param2.setType("String");
		param2.setValue("20");
		
		List<AlgorithmParameter> lstParams = new ArrayList<AlgorithmParameter>();
		lstParams.add(param1);
		lstParams.add(param2);
		
		algorithm.setParameters(lstParams);
		
		ICalculatePlugin cal=PluginFactory.getCalculatePlugin();
		int result= cal.cal(algorithm);
		System.out.println("result***"+result);
	}

}
