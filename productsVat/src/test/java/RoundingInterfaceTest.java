import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import vatfunctions.RoundingInterface;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
public class RoundingInterfaceTest {

    RoundingInterface roundingInterface;

    private BigDecimal value;
    private BigDecimal roundedValue;

    @Before
    public void setUp(){
        roundingInterface = new RoundingInterface() {};
    }

    public RoundingInterfaceTest(BigDecimal value, BigDecimal roundedValue) {
        this.value = value;
        this.roundedValue = roundedValue;
    }

    @Parameterized.Parameters(name = "{index}: amount({0}) rounded to {1}" )
    public static Collection toRoundAmounts() {
        return Arrays.asList(new Object[][]{
                {new BigDecimal("0.99"), new BigDecimal("1.00")},
                {new BigDecimal("1.00"), new BigDecimal("1.00")},
                {new BigDecimal("1.01"), new BigDecimal("1.05")},
                {new BigDecimal("1.02"), new BigDecimal("1.05")},
        });
    }

    @Test
    public void should_round_Up_On_5_cents() {
        assertEquals(roundingInterface.round(value),
                roundedValue);
    }

}
