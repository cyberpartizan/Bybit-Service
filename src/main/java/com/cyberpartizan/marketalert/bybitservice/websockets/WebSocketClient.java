package com.cyberpartizan.marketalert.bybitservice.websockets;

import com.cyberpartizan.marketalert.bybitservice.constants.Constants;
import com.cyberpartizan.marketalert.bybitservice.enums.SubscriptionEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
public class WebSocketClient extends org.java_websocket.client.WebSocketClient {

    private final ObjectMapper objectMapper;

    public WebSocketClient(ObjectMapper objectMapper) {
        super(URI.create(Constants.WEBSOCKET_SPOT));
        this.objectMapper = objectMapper;
        this.connect();
    }

    @Override
    public void onOpen(ServerHandshake handshakeData) {
        System.out.println("Bybit websocket has opened");
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("closed with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onMessage(String message) {
        System.out.println(message);
    }

    @SneakyThrows
    public void subscriptionControl(String topic, SubscriptionEnum subscriptionEnum) {
        Map<String, Object> subscribeRequest = new HashMap<>();
        subscribeRequest.put("op", subscriptionEnum.getStr());
        subscribeRequest.put("args", new String[]{topic});

        String subscribeMessage = objectMapper.writeValueAsString(subscribeRequest);
        send(subscribeMessage);
    }
}
