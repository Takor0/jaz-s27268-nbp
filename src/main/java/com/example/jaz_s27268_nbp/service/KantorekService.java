package com.example.jaz_s27268_nbp.service;

import com.example.jaz_s27268_nbp.client.NbpClient;
import com.example.jaz_s27268_nbp.exception.NoRatesException;
import com.example.jaz_s27268_nbp.model.ExchangeRatesPerPeriod;
import com.example.jaz_s27268_nbp.model.NbpResponse;
import com.example.jaz_s27268_nbp.repository.ExchangeRatesPerPeriodRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KantorekService {
    private final NbpClient nbpClient;
    private final ExchangeRatesPerPeriodRepository exchangeRatesPerPeriodRepository;

    public KantorekService(NbpClient nbpClient, ExchangeRatesPerPeriodRepository exchangeRatesPerPeriodRepository) {
        this.nbpClient = nbpClient;
        this.exchangeRatesPerPeriodRepository = exchangeRatesPerPeriodRepository;
    }

    public double getAverageExchangeRatesPerPeriod(String currencyCode, int days) {
        NbpResponse response = nbpClient.getExchangeRatesPerPeriod(currencyCode, days);
        double ratesAvg = response.getRates().stream()
                .mapToDouble(NbpResponse.Rate::getMid)
                .average()
                .orElseThrow(() -> new NoRatesException("No rates available for the given period"));
        LocalDateTime date_time = LocalDateTime.now();
        ExchangeRatesPerPeriod exchangeRatesPerPeriod = new ExchangeRatesPerPeriod(
                currencyCode,
                days,
                ratesAvg,
                date_time
        );
        exchangeRatesPerPeriodRepository.save(exchangeRatesPerPeriod);
        return ratesAvg;
    }
}
