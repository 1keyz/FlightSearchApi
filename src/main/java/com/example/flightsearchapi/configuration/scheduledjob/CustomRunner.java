package com.example.flightsearchapi.configuration.scheduledjob;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomRunner implements Runnable {
    private GetFlightInformationJob getFlightInformationJob;
    @Override
    public void run() {
        getFlightInformationJob.flightInformation();
    }


}
