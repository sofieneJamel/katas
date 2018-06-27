import domain.Purchase;
import org.junit.Test;

import java.math.BigDecimal;

import static Factroy.TestFactory.*;
import static org.junit.Assert.assertEquals;

public class PurchaseTest {

    @Test
    public void should_apply_ten_percentage_vat_for_misc_products() {
        //Given
        Purchase purchase = aPurchase()
                .withProduct(aParfum()
                            .withPrice(new BigDecimal("100"))
                            .build())
                .build();

        //When
        BigDecimal vatAmount = purchase.calcPurchaseVat();

        //Then
        assertEquals(vatAmount, new BigDecimal("10.00"));
    }

    @Test
    public void should_not_apply_ten_percentage_vat_for_not_misc_products() {
        //Given
        Purchase purchase = aPurchase()
                .withProduct(aChocolateBar()
                        .withPrice(new BigDecimal("100"))
                        .build())
                .build();

        //When
        BigDecimal vatAmount = purchase.calcPurchaseVat();

        //Then
        assertEquals(vatAmount, new BigDecimal("0.00"));
    }

    @Test
    public void should_apply_five_percentage_vat_for_imported_products() {
        //Given
        Purchase purchase = aPurchase()
                .withProduct(anImportedParfum()
                        .withPrice(new BigDecimal("100"))
                        .build())
                .build();
        //When
        BigDecimal vatAmount = purchase.calcPurchaseVat();

        //Then
        assertEquals(vatAmount, new BigDecimal("15.00"));
    }
}
