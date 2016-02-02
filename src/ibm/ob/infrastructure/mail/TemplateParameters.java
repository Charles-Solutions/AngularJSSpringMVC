package ibm.ob.infrastructure.mail;

import java.util.HashMap;

public class TemplateParameters extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TemplateParameters() {
		// TODO Auto-generated constructor stub
	
	}
	
	public void addParameter(String name, Object value){
		this.put(name, value);
	}

}
