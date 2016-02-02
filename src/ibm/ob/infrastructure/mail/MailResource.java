package ibm.ob.infrastructure.mail;

import java.io.File;

public class MailResource {

	private String contentId;
	
	private File resource;
		
	
	public MailResource(String contentId, File resource) {
		super();
		this.contentId = contentId;
		this.resource = resource;
	}

	public String getContentId() {
		return contentId;
	}
	
	public File getResource() {
		return resource;
	}
	
	
}
