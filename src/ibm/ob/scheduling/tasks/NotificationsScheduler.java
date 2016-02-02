package ibm.ob.scheduling.tasks;

import java.util.Date;

import org.springframework.scheduling.annotation.Async;

import ibm.ob.stereotypes.TaskScheduler;

@TaskScheduler
public class NotificationsScheduler {

	
	@Async
	public void sendNotificationToUsers(){
		System.out.println("Sending notification to users: " + new Date());
	}
	
	@Async
	public void sendNotificationToVendors(){
		System.out.println("Sending notification to vendors: " + new Date());
	}
	
}
