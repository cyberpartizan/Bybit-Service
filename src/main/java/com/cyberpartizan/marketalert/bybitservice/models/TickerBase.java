package com.cyberpartizan.marketalert.bybitservice.models;

import com.cyberpartizan.marketalert.bybitservice.enums.BrokerEnum;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TickerBase {

    @JsonAlias({"symbol", "instId", "name"})
    private String symbol;
    private BrokerEnum broker;
}
