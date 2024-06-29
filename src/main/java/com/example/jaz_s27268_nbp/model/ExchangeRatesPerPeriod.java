package com.example.jaz_s27268_nbp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ExchangeRatesPerPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Id")
    private Long id;
    @Column
    @Schema(name = "Exchange rate currency", example = "usd")
    private String currency;
    @Column
    @Schema(name = "Average exchange rate", example = "4.123")
    private double averageRate;
    @Column
    @Schema(name = "Created at date time", example = "2023-01-01 12:12:12")
    private LocalDateTime createdAt;
    @Column
    @Schema(name = "Aggregation start date", example = "2023-01-01")
    private LocalDate startDate;
    @Column
    @Schema(name = "Aggregation end date", example = "2023-01-10")
    private LocalDate endDate;

    public ExchangeRatesPerPeriod() {

    }


    public ExchangeRatesPerPeriod(String currency, double averageRate, LocalDateTime createdAt, LocalDate startDate, LocalDate endDate) {
        this.currency = currency;
        this.averageRate = averageRate;
        this.createdAt = createdAt;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime dateTime) {
        this.createdAt = dateTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
