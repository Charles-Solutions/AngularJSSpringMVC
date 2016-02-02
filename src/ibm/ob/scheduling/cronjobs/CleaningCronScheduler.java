package ibm.ob.scheduling.cronjobs;

import ibm.ob.stereotypes.CronScheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

@CronScheduler
public class CleaningCronScheduler {
	
	@Scheduled(cron = "${cron.cleaning.files}")
    public void cleanTempFiles()
    {
        System.out.println("Cleaning temp files: "+ new Date());
    }
	
	@Scheduled(cron = "${cron.cleaning.data}")
    public void cleanData()
    {
        System.out.println("Cleaning data: "+ new Date());
    }

}
