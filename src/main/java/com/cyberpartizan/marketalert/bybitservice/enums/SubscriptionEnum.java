package com.cyberpartizan.marketalert.bybitservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SubscriptionEnum {
    SUBSCRIBE("subscribe"),
    UNSUBSCRIBE("unsubscribe");

    private final String str;
}
