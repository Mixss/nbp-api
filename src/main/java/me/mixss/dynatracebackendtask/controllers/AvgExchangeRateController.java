package me.mixss.dynatracebackendtask.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.mixss.dynatracebackendtask.exceptions.ApiBadResponseException;
import me.mixss.dynatracebackendtask.services.AvgExchangeRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AvgExchangeRateController {

    private final AvgExchangeRateService avgExchangeRateService;

    public AvgExchangeRateController(AvgExchangeRateService avgExchangeRateService) {
        this.avgExchangeRateService = avgExchangeRateService;
    }

    @GetMapping ("/avg/{currencyCode}/{date}/")
    public String getAvgExchangeRateAtDay(@PathVariable String currencyCode, @PathVariable String date ) {
        Float averageRate = avgExchangeRateService.getAvgExchangeRateAtDate(currencyCode, date);
        return String.valueOf(averageRate);
    }
}
