package com.cyberpartizan.marketalert.bybitservice.api;


import com.cyberpartizan.marketalert.bybitservice.models.TickerBase;
import com.cyberpartizan.marketalert.bybitservice.models.TickerPrice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static com.cyberpartizan.marketalert.bybitservice.constants.Constants.TICKERS_URL;
import static com.cyberpartizan.marketalert.bybitservice.enums.BrokerEnum.BYBIT;

@Component
@RequiredArgsConstructor
public class ApiClient {

    protected final ObjectMapper objectMapper;
    protected final OkHttpClient client;

    @SneakyThrows
    public List<TickerBase> getTickers() {
        Request request = new Request.Builder()
                .url(TICKERS_URL)
                .build();
        List<TickerBase> tickerList = getList(request, TickerBase.class);
        tickerList.forEach(e -> e.setBroker(BYBIT));
        return tickerList;
    }

    @SneakyThrows
    public List<TickerPrice> getTickersPrice() {
        Request request = new Request.Builder()
                .url(TICKERS_URL)
                .build();
        List<TickerPrice> tickerList = getList(request, TickerPrice.class);
        tickerList.forEach(e -> e.setBroker(BYBIT));
        return tickerList;
    }

    @SneakyThrows
    private <T> List<T> getList(Request request, Class<T> clazz){
        Call call = client.newCall(request);
        Response response = call.execute();
        String data = objectMapper.readTree(Objects.requireNonNull(response.body()).string()).get("result").get("list").toString();
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
        return objectMapper.readValue(data, collectionType);
    }
}
