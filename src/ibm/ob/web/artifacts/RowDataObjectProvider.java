package ibm.ob.web.artifacts;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RowDataObjectProvider {
	
	
	public static <T> Map<String, Object> getDataMap(T obj){
		
		Map<String, Object> properties = new HashMap<String, Object>();
		
		Method[] methods =  obj.getClass().getDeclaredMethods();
		
		for (Method method : methods) {
			
			if(method.getName().startsWith("get")){
				
				String prop=  method.getName().substring(3, method.getName().length());
				
				prop = prop.replace(String.valueOf(prop.charAt(0)), String.valueOf(prop.charAt(0)).toLowerCase());
			
				try {				
					
					Object propValue = method.invoke(obj, null);
					
					properties.put(prop, propValue);
				
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			
		}		
		return properties;		
	}
	
}
