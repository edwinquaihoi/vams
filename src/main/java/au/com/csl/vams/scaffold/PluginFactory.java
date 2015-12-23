package au.com.csl.vams.scaffold;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public final class PluginFactory{

	public static void init()
	{
		ResourceBundle bundle=ResourceBundle.getBundle("au.com.csl.pluginconfig",Locale.getDefault());
		Set<String> keys=bundle.keySet();
		for(String key: keys)
		{
			fImplementations.put(key, bundle.getString(key));
		}
	
	}
	
	private static final Map<String, String> fImplementations = new LinkedHashMap<>();
	
	public static ICalculatePlugin getCalculatePlugin()
	{
		init();
		String className = fImplementations.get("au.com.csl.vams.scaffold.ICalculatePlugin");
		ICalculatePlugin plugin =(ICalculatePlugin)buildObject(className);
		return plugin;
	}
	
	
	private static Object buildObject(String aClassName) {
		Object result = null;
		try {
			Class implClass = Class.forName(aClassName);
			result = implClass.newInstance();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
}
