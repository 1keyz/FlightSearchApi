package com.example.flightsearchapi.configuration.scheduledjob;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;


@Configuration
@ComponentScan(basePackages = "com.example.flightsearchapi")
public class ShceduledConfiguration {
    private GetFlightInformationJob getFlightInformationJob;

    public ShceduledConfiguration(GetFlightInformationJob getFlightInformationJob) {
        this.getFlightInformationJob = getFlightInformationJob;
    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(1);
        scheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        scheduler.initialize();
        scheduler.submit(new CustomRunner(getFlightInformationJob));

        return scheduler;
    }
}
