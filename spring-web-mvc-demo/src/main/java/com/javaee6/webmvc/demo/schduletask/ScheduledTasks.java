package com.javaee6.webmvc.demo.schduletask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledTasks {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	/*
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		try
		{
			//Thread.sleep(8000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Do schedule task after 6000->after completion of previous task
	@Scheduled(fixedDelay = 6000)
	public void scheduleFixedDelayTask() {
		log.info("Fixed delay The time is now {}", dateFormat.format(new Date()));
		try
		{
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
		log.info("fixedRate async The time is now {}", dateFormat.format(new Date()));
        Thread.sleep(5000);
    }
	*/
	@Scheduled(cron = "0 24 * * * ?")
	public void scheduleTaskUsingCronExpression() {
	 
		log.info("scheduleTaskUsingCronExpressione time is now {}", dateFormat.format(new Date()));
	}
}
