package com.example.jaz_s27268_nbp.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ExchangeRatesPerPeriod {


    public ExchangeRatesPerPeriod(String currency, int days, double averageRate, LocalDateTime date_time) {
        this.currency = currency;
        this.days = days;
        this.averageRate = averageRate;
        this.date_time = date_time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String currency;
    @Column
    private int days;
    @Column
    private double averageRate;
    @Column
    private LocalDateTime date_time;

    public ExchangeRatesPerPeriod() {

    }
}
