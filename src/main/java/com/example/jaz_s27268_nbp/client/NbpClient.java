package com.example.jaz_s27268_nbp.client;

import com.example.jaz_s27268_nbp.model.NbpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NbpClient {
    private final String baseUrl = "http://api.nbp.pl/api/";
    private final RestTemplate restTemplate;

    public NbpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NbpResponse getExchangeRatesPerPeriod(String currencyCode, int days) {

        return restTemplate.getForObject(this.baseUrl + "exchangerates/rates/a/" + currencyCode + "/last/" + days + "/", NbpResponse.class);
}


}
