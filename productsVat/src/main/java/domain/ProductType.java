package domain;

import java.math.BigDecimal;

public enum ProductType {
    Book,
    Food,
    Drugs,
    Miscellaneous {
        public BigDecimal getVatPercentage() {
            return BigDecimal.TEN;
        }
    };

    public BigDecimal getVatPercentage() {
        return BigDecimal.ZERO;
    }
}
