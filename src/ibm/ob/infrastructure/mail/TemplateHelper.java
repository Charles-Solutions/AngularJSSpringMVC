package ibm.ob.infrastructure.mail;


import java.util.List;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;



@Component
public class TemplateHelper {
	
	private static final String TEMPLATES_FOLDER = "cu/edu/reduc/solicitudes/application/mail/templates/";
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	
	public HtmlTemplate createHtmlTemplate(String templateName, TemplateParameters params, List<MailResource> resources){
		
		try {
			
			String body =  VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, TEMPLATES_FOLDER + templateName, "UTF-8", params);			
			
			return new HtmlTemplate(body, resources);
		
		} catch (VelocityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return null;
	}
	
}
