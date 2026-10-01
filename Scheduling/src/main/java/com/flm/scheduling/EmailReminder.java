package com.flm.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailReminder {
	
	@Scheduled(cron = " */10 * * * * * ")
	public void sendEmail() {
		System.out.println("Send Email......");
	}

}
