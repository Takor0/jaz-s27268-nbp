package com.example.jaz_s27268_nbp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ExchangeRatesPerPeriod {


    public ExchangeRatesPerPeriod(String currency, double averageRate, LocalDateTime dateTime, LocalDate startDate, LocalDate endDate) {
        this.currency = currency;
        this.averageRate = averageRate;
        this.dateTime = dateTime;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String currency;
    @Column
    private double averageRate;
    @Column
    private LocalDateTime dateTime;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;

    public ExchangeRatesPerPeriod() {

    }
}
