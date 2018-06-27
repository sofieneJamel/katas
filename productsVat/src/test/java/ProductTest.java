import domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static Factroy.TestFactory.aBook;

public class ProductTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_raise_IllegalArgumentException_when_price_isNullOrLowerOrEqualsToZero() {

        //Expect
        expectedException.expect(java.lang.IllegalArgumentException.class);
        expectedException.expectMessage("price value could not be null,zero or negative");

        //Given
        Product.Builder aBookBuilder = aBook().withPrice(new BigDecimal("0"));

        //When
        aBookBuilder.build();
    }

    @Test
    public void should_raise_IllegalArgumentException_when_productType_isNull() {

        //Expect
        expectedException.expect(java.lang.IllegalArgumentException.class);
        expectedException.expectMessage("productType could not be null");

        //Given
        Product.Builder aProductBuilder = new Product.Builder()
                .withProductType(null)
                .withPrice(new BigDecimal("10"));

        //When
        aProductBuilder.build();
    }
}
