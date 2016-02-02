package ibm.ob.infrastructure.jms;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

@Component("messageListener")
public class MQListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		System.out.println("Doing something with the received message");
	}
}
