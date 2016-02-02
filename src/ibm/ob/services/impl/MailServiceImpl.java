package ibm.ob.services.impl;

import ibm.ob.entities.User;
import ibm.ob.infrastructure.mail.HtmlTemplate;
import ibm.ob.infrastructure.mail.MailData;
import ibm.ob.infrastructure.mail.MailSender;
import ibm.ob.services.MailService;

import java.io.File;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MailServiceImpl implements MailService {
		
	@Autowired
	private MailSender sender;
		

	@Override
	public void sendTestEmail(User user) {		
		System.out.println("Sending email to " + user.getEmail() + " Id:" + user.getUserId());
	}	
	
	private void send(String from, String alias, String subject, String[] to, String text, HtmlTemplate template, File[] attachments) throws MessagingException{
		if(template != null){
			this.sender.sendEmail(new MailData(from, alias, subject, to, template, attachments));
		}
		else if(text != null){
			this.sender.sendEmail(new MailData(from, alias, subject, to, text, attachments));
		}		
	}

	/*@Override
	public void sendHtmlEmail(String from, String alias, String subject, String[] to, HtmlTemplate template) throws MessagingException {
		this.sender.sendEmail(new MailData(from, alias, subject, to, template, null));		
	}

	@Override
	public void sendHtmlEmail(String from, String alias, String subject,String[] to, HtmlTemplate template, File[] attachments) throws MessagingException{
		this.sender.sendEmail(new MailData(from, alias, subject, to, template, attachments));				
	}

	@Override
	public void sendHtmlEmail(String subject, String[] to, HtmlTemplate template) throws MessagingException {
		this.sender.sendEmail(new MailData("", "", subject, to, template, null));			
	}

	@Override
	public void sendHtmlEmail(String subject, String[] to,	HtmlTemplate template, File[] attachments) throws MessagingException {
		this.sender.sendEmail(new MailData("", "", subject, to, template, attachments));		
	}

	@Override
	public void sendTextEmail(String from, String alias, String subject, String[] to, String text) throws MessagingException {
		this.sender.sendEmail(new MailData(from, alias, subject, to, text, null));		
	}

	@Override
	public void sendTextEmail(String from, String alias, String subject, String[] to, String text, File[] attachments) throws MessagingException {
		this.sender.sendEmail(new MailData(from, alias, subject, to, text, attachments));		
	}

	@Override
	public void sendTextEmail(String subject, String[] to, String text) throws MessagingException {
		this.sender.sendEmail(new MailData("", "", subject, to, text, null));
	}
	
	@Override
	public void sendTextEmail(String subject, String[] to, String text,	File[] attachments) throws MessagingException {
		this.sender.sendEmail(new MailData("", "", subject, to, text, null));	
	}*/

}
