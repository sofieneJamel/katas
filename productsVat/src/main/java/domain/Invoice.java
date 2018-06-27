package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;


public class Invoice {

    private static Logger logger = LoggerFactory.getLogger(Invoice.class);

    private List<Purchase> purchases;
    private BigDecimal taxesAmount;
    private BigDecimal htAmount;
    private BigDecimal priceTTCAmount;

    private BigDecimal calcTotalTaxesAmount() {
        this.taxesAmount = this.getPurchases()
                .stream().map(Purchase::calcPurchaseVat)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        logger.info("Montant des taxes : {}",taxesAmount);
        return this.taxesAmount;
    }

    private BigDecimal calcTotalHTAmount() {
        this.htAmount = this.getPurchases()
                .stream().map(purchase -> purchase.getProduct().getPrice().multiply(BigDecimal.valueOf(purchase.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return this.htAmount;
    }

    public Invoice processInvoice() {
        BigDecimal ttcAmount = calcTotalTaxesAmount().add(calcTotalHTAmount());
        logger.info("Total : {}",ttcAmount);
        this.priceTTCAmount = ttcAmount;
        return this;
    }


    public List<Purchase> getPurchases() {
        return purchases;
    }

    public BigDecimal getTaxesAmount() {
        return taxesAmount;
    }

    public BigDecimal getPriceTTCAmount() {
        return priceTTCAmount;
    }

    public BigDecimal getHtAmount() {
        return htAmount;
    }


    private Invoice(Builder builder) {
        this.purchases = builder.purchases;
    }

    public static final class Builder {
        private List<Purchase> purchases;

        public Builder() {
        }

        public Builder withPurchases(List<Purchase> purchases) {
            this.purchases = purchases;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }
}
