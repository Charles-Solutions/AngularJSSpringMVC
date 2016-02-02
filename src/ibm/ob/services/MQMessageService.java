package ibm.ob.services;

import javax.jms.JMSException;

public interface MQMessageService {
	
	public void sendMessage(final String text) throws JMSException;
	
	public String readMessage() throws JMSException;

}
