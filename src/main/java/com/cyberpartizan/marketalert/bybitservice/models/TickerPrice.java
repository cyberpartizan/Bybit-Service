package com.cyberpartizan.marketalert.bybitservice.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TickerPrice extends TickerBase {
    @JsonAlias({"bid", "bid1Price"})
    private String price;
}
