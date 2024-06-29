package com.example.jaz_s27268_nbp.controller;

import com.example.jaz_s27268_nbp.model.ExchangeRatesPerPeriod;
import com.example.jaz_s27268_nbp.service.NbpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/nbp/exchange-rate")
public class NbpController {
    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @Operation(summary = "Get average exchange rate to pln", description = "Returns average exchange rate to pln for given currency code in given period")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "200", description = "Ok")
    })
        @GetMapping("/average/{currencyCode}/")
    public ResponseEntity<ExchangeRatesPerPeriod> getAverageExchangeRates(
            @Parameter(in = ParameterIn.PATH, name = "currencyCode", description = "Currency code of wanted exchange rate", example = "usd") @PathVariable("currencyCode") String currencyCode,
            @Parameter(name = "startDate", description = "Aggregation start date", example = "2020-01-01") @RequestParam("startDate") LocalDate startDate,
            @Parameter(name = "endDate", description = "Aggregation end date", example = "2020-01-11") @RequestParam("endDate") LocalDate endDate
    ) {
        ExchangeRatesPerPeriod exchangeRatesPerPeriod = nbpService.getAndStoreAverageExchangeRatesPerPeriod(currencyCode, startDate, endDate);
        return ResponseEntity.ok(exchangeRatesPerPeriod);
    }
}
