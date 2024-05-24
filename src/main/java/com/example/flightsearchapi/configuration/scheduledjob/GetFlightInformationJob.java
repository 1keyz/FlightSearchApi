package com.example.flightsearchapi.configuration.scheduledjob;

import com.example.flightsearchapi.dtos.requests.FlightRequestDto;
import com.example.flightsearchapi.dtos.requests.MockoonRequest;
import com.example.flightsearchapi.services.abstracts.FlightService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetFlightInformationJob {
    @Value("${mockoon.url}")
    private String url;
    @Autowired
    private FlightService flightService;



    @Scheduled(cron = "0 0 12 * * ?")
    public void flightInformation() {
        MockoonRequest requestDtos = flightInformationSupporter();
        flightService.createAllFlight(requestDtos.getFlights());
    }

    private MockoonRequest flightInformationSupporter() {
        RestTemplate template = new RestTemplate(); // mockoona erişimimizi sağlıyor ve http verilerini alabiliyoruz

        try {
            ResponseEntity<MockoonRequest> requestDtoList = template.getForEntity(url, MockoonRequest.class);
            return requestDtoList.getBody();
        }catch (RestClientException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
