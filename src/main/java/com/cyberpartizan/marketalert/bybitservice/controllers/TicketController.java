package com.cyberpartizan.marketalert.bybitservice.controllers;

import com.cyberpartizan.marketalert.bybitservice.api.ApiClient;
import com.cyberpartizan.marketalert.bybitservice.models.TickerBase;
import com.cyberpartizan.marketalert.bybitservice.models.TickerPrice;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/tickers")
@RequiredArgsConstructor
public class TicketController {

    private final ApiClient apiClient;

    @GetMapping("/")
    public List<TickerBase> getTickers() {
        return apiClient.getTickers();
    }

    @GetMapping("/price")
    public List<TickerPrice> getTickersPrice() {
        return apiClient.getTickersPrice();
    }
}


