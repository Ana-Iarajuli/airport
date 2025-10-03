package enums;

import java.math.BigDecimal;

public enum SeatClass {

    ECONOMY("ECO", 1.0),
    BUSINESS("BUS", 1.6),
    FIRST("FST", 2.2);

    private final String code;
    private final double priceMultiplier;

    SeatClass(String code, double priceMultiplier) {
        this.code = code;
        this.priceMultiplier = priceMultiplier;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal applyTo(BigDecimal base) {
        return base.multiply(BigDecimal.valueOf(priceMultiplier));
    }

    public boolean isPremium() {
        return this == BUSINESS || this == FIRST;
    }
}

