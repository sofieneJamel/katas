package vatfunctions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface RoundingInterface {

    BigDecimal FIVE_CENTS_ROUND = new BigDecimal("0.05");

    default BigDecimal round(BigDecimal value) {
        return value.divide(FIVE_CENTS_ROUND, 0, RoundingMode.CEILING)
                .multiply(FIVE_CENTS_ROUND);
    }

}
