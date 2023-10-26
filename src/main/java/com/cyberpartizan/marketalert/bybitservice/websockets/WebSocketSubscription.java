package com.cyberpartizan.marketalert.bybitservice.websockets;

import com.cyberpartizan.marketalert.bybitservice.enums.SubscriptionEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebSocketSubscription {

    private final WebSocketClient webSocketClient;

    public void subscriptionControl(String topic, SubscriptionEnum subscriptionEnum) {
        if (SubscriptionEnum.SUBSCRIBE.equals(subscriptionEnum) && webSocketClient.isClosed()) {
            webSocketClient.reconnect();
        }
        webSocketClient.subscriptionControl(topic, subscriptionEnum);
    }
}
