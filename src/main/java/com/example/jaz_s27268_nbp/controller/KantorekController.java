package com.example.jaz_s27268_nbp.controller;

import com.example.jaz_s27268_nbp.service.KantorekService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kantorek/exchange-rate")
public class KantorekController {
    private final KantorekService kantorekService;

    public KantorekController(KantorekService kantorekService) {
        this.kantorekService = kantorekService;
    }

    @Operation(summary = "Get average exchange rate to pln", description = "Returnnig average exchange rate to pln for given currency code and days")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "200", description = "Ok")
    })
    @GetMapping("/average/{currency_code}/")
    public ResponseEntity<Double> getAverageExchangeRates(
            @PathVariable("currency_code") String currency_code,
            @RequestParam(value = "days", defaultValue = "1") int days
    ) {
        double average = kantorekService.getAverageExchangeRatesPerPeriod(currency_code, days);
        return ResponseEntity.ok(average);
    }
}
