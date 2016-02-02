package ibm.ob.infrastructure.mail;

import java.io.File;

public class MailData {

	private String from; 
	
	private String alias; 
	
	private String subject; 
	
	private String[] to;
	
	private String textBody;
	
	private HtmlTemplate template;
	
	private File[] attachments;
	
    	
	
	public MailData(String from, String alias, String subject, String[] to,	String textBody, File[] attachments) {
		super();
		this.from = from;
		this.alias = alias;
		this.subject = subject;
		this.to = to;
		this.textBody = textBody;
		this.template = null;
		this.attachments = attachments;
	}
	
	public MailData(String from, String alias, String subject, String[] to,	HtmlTemplate template, File[] attachments) {
		super();
		this.from = from;
		this.alias = alias;
		this.subject = subject;
		this.to = to;
		this.textBody = null;
		this.template = template;
		this.attachments = attachments;
	}

	public String getFrom() {
		return from;
	}

	public String getAlias() {
		return alias;
	}

	public String getSubject() {
		return subject;
	}

	public String[] getTo() {
		return to;
	}

	public String getBody() {
		return template != null ? template.getHtmlBody() : textBody;
	}

	public HtmlTemplate getTemplate() {
		return template;
	}
	
	public File[] getAttachments() {
		return attachments;
	}
	
	public boolean isHtml() {
		return template != null;
	}
	
}
