package com.example.jaz_s27268_nbp.service;

import com.example.jaz_s27268_nbp.client.NbpClient;
import com.example.jaz_s27268_nbp.exception.NoRatesException;
import com.example.jaz_s27268_nbp.model.ExchangeRatesPerPeriod;
import com.example.jaz_s27268_nbp.model.NbpResponse;
import com.example.jaz_s27268_nbp.repository.ExchangeRatesPerPeriodRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NbpService {
    private final NbpClient nbpClient;
    private final ExchangeRatesPerPeriodRepository exchangeRatesPerPeriodRepository;

    public NbpService(NbpClient nbpClient, ExchangeRatesPerPeriodRepository exchangeRatesPerPeriodRepository) {
        this.nbpClient = nbpClient;
        this.exchangeRatesPerPeriodRepository = exchangeRatesPerPeriodRepository;
    }

    public ExchangeRatesPerPeriod getAndStoreAverageExchangeRatesPerPeriod(String currencyCode, LocalDate startDate, LocalDate endDate) {
        NbpResponse response = nbpClient.getExchangeRatesPerPeriod(currencyCode, startDate, endDate);
        double ratesAvg = response.getRates().stream()
                .mapToDouble(NbpResponse.Rate::getMid)
                .average()
                .orElseThrow(() -> new NoRatesException("No rates available for the given period"));
        LocalDateTime reqDate = LocalDateTime.now();
        ExchangeRatesPerPeriod exchangeRatesPerPeriod = new ExchangeRatesPerPeriod(
                currencyCode,
                ratesAvg,
                reqDate,
                startDate,
                endDate
        );
        exchangeRatesPerPeriodRepository.save(exchangeRatesPerPeriod);
        return exchangeRatesPerPeriod;
    }
}
