package au.com.csl.vams.scaffold;

import java.util.Iterator;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.model.relational.AlgorithmParameter;


public class CalculatePluginImpl implements ICalculatePlugin<Algorithm> {
	public CalculatePluginImpl() {
	}
	
	@Override
	public int cal(Algorithm algorithm) {
		int result = 0;
		Iterator<AlgorithmParameter> itr = algorithm.getParameters().iterator();
		// to do logic for calculation
		while(itr.hasNext())
		{
			AlgorithmParameter algParam = itr.next();
			result += Integer.valueOf(algParam.getValue());
			
		}
		return result;
	}

}
