package ibm.ob.infrastructure.mail;

import java.util.List;


/**
 * @author Alex
 *
 */
public class HtmlTemplate {

	private List<MailResource> resources;
	
	private String htmlBody;
	
	public HtmlTemplate(String htmlBody, List<MailResource> resources) {
		super();		
		this.htmlBody = htmlBody;
		this.resources = resources;		
	}	
	
	public List<MailResource> getResources() {
		return resources;
	}
	
	public String getHtmlBody() {
		return htmlBody;
	}
	
	
}
