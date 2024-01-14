package com.learning.technology.scheduling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExecuteScheduler {
    private static final Logger logger = LogManager.getLogger(ExecuteScheduler.class);

    //this method performs the task in every 5 min
    @Scheduled(cron = "0 0/5 * * * ?")
    public void performCheck(){
        logger.info("Suspending user from OKTA and sending mail for device unavailable");
    }
}
