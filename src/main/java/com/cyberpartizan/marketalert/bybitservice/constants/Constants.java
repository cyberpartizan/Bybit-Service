package com.cyberpartizan.marketalert.bybitservice.constants;

public class Constants {
    public static String URL = "https://api-testnet.bybit.com/v5";
    public static String TICKERS_URL = URL + "/market/tickers?category=spot";
    public static String WEBSOCKET_URL = "wss://stream-testnet.bybit.com/v5";
    public static String WEBSOCKET_SPOT = WEBSOCKET_URL + "/public/spot";
}
