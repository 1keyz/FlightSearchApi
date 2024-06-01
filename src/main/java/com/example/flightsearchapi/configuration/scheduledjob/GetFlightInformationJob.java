package com.example.flightsearchapi.configuration.scheduledjob;

import com.example.flightsearchapi.dtos.MockoonsRequest;
import com.example.flightsearchapi.services.abstracts.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class GetFlightInformationJob {
    @Value("${mockoons.url}")
    private String url;
    @Autowired
    private FlightService flightService;



    @Scheduled(cron = "0 0 12 * * ?")
    public void flightInformation() {
        MockoonsRequest requestDtos = flightInformationSupporter();
        flightService.createAllFlight(requestDtos.getFlights());
    }

    private MockoonsRequest flightInformationSupporter() {
        RestTemplate template = new RestTemplate(); // mockoona erişimimizi sağlıyor ve http verilerini alabiliyoruz

        try {
            ResponseEntity<MockoonsRequest> requestDtoList = template.getForEntity(url, MockoonsRequest.class);
            return requestDtoList.getBody();
        }catch (RestClientException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
