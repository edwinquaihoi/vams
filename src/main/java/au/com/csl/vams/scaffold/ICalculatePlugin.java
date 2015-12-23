package au.com.csl.vams.scaffold;

import java.util.Map;
import au.com.csl.vams.model.relational.Algorithm;


public interface ICalculatePlugin<T> extends IPlugin{
  public int cal(Algorithm algorithm);
}
