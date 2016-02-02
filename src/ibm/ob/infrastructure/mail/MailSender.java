package ibm.ob.infrastructure.mail;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;



@Component
public class MailSender{
	
	@Autowired
	private JavaMailSender javaMailSender;	
	
	
	@Async
	public void sendEmail(final MailData data) throws MessagingException{
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		this.createMail(message, data);
		
		javaMailSender.send(message);
	}
	
    
	private void createMail(MimeMessage mimeMessage, MailData data) throws MessagingException{
		
	    final MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMessage, true);	    
	    
	    msgHelper.setFrom(data.getFrom());
	    msgHelper.setTo(data.getTo());
	    msgHelper.setSubject(data.getSubject());
        msgHelper.setSentDate(new Date());
       
        if(data.isHtml()){        	
        	msgHelper.setText(data.getBody(), true);      	
        	List<MailResource> resources = data.getTemplate().getResources();
        	  if(resources != null)
        		 for (MailResource res : resources) 
      			  	  msgHelper.addInline(res.getContentId(), res.getResource());
        }
      
        else
        	msgHelper.setText(data.getBody(), false);
  	           
        File[] attachments = data.getAttachments();
        if(attachments != null){
        	for (File file : attachments) {
    			msgHelper.addAttachment(file.getName(), file);
    		}        	
        }    
	}
	
}
