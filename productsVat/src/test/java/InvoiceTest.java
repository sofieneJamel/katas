import domain.Invoice;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static Factroy.TestFactory.*;
import static org.junit.Assert.assertEquals;


public class InvoiceTest {

    @Test
    public void should_edit_invoice_for_aBook_aCd_aChocolate() {
        // Given
        Invoice invoice = new Invoice.Builder()
                .withPurchases(Arrays.asList(
                        aPurchase().withProduct(
                                aBook()
                                .withPrice(new BigDecimal("12.49"))
                                .build())
                        .build(),
                        aPurchase().withProduct(
                                aCD()
                                .withPrice(new BigDecimal("14.99"))
                                .build())
                        .build(),
                        aPurchase().withProduct(
                                aChocolateBar()
                                .withPrice(new BigDecimal("0.85"))
                                .build())
                        .build()
                ))
                .build();

        // When
        invoice.processInvoice();

        // Then
        assertEquals(new BigDecimal("1.50"), invoice.getTaxesAmount());
        assertEquals(new BigDecimal("29.83"), invoice.getPriceTTCAmount());
    }

    @Test
    public void should_edit_invoice_for_anImportedChocolate_anImportedParfum() {
        // Given
        Invoice invoice = new Invoice.Builder()
                .withPurchases(Arrays.asList(
                        aPurchase().withProduct(
                                anImportedChocolateBox()
                                        .withPrice(new BigDecimal("10.00"))
                                        .build())
                                .build(),
                        aPurchase().withProduct(
                                anImportedParfum()
                                        .withPrice(new BigDecimal("47.50"))
                                        .build())
                                .build()
                ))
                .build();

        // When
        invoice.processInvoice();

        // Then
        assertEquals(new BigDecimal("7.65"), invoice.getTaxesAmount());
        assertEquals(new BigDecimal("65.15"), invoice.getPriceTTCAmount());
    }

    @Test
    public void should_edit_invoice_for_anImportedParfum_aParfum_aDrugs_anImportedChocolate() {
        // Given
        Invoice invoice = new Invoice.Builder()
                .withPurchases(Arrays.asList(
                        aPurchase().withProduct(
                                anImportedParfum()
                                        .withPrice(new BigDecimal("27.99"))
                                        .build())
                                .build(),
                        aPurchase().withProduct(
                                aParfum()
                                        .withPrice(new BigDecimal("18.99"))
                                        .build())
                                .build(),
                        aPurchase().withProduct(
                                aDrug()
                                        .withPrice(new BigDecimal("9.75"))
                                        .build())
                                .build(),
                        aPurchase().withProduct(
                                anImportedChocolateBox()
                                        .withPrice(new BigDecimal("11.25"))
                                        .build())
                                .build()
                ))
                .build();
            // When
        invoice.processInvoice();

        // Then
        assertEquals(new BigDecimal("6.70"), invoice.getTaxesAmount());
        assertEquals(new BigDecimal("74.68"), invoice.getPriceTTCAmount());
    }

}
