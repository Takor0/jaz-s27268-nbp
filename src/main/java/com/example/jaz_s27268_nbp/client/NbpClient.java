package com.example.jaz_s27268_nbp.client;

import com.example.jaz_s27268_nbp.model.NbpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class NbpClient {
    private final String baseUrl = "http://api.nbp.pl/api/";
    private final RestTemplate restTemplate;

    public NbpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NbpResponse getExchangeRatesPerPeriod(String currencyCode, LocalDate startDate, LocalDate endDate) {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String url = this.baseUrl + "exchangerates/rates/a/" + currencyCode + "/" + startDate.format(formatters) + "/" + endDate.format(formatters);
        return restTemplate.getForObject(url, NbpResponse.class);
    }


}
