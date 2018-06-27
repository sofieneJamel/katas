package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vatfunctions.RoundingInterface;

import java.math.BigDecimal;
import java.util.function.Function;

public class Purchase implements RoundingInterface {
    private static Logger logger = LoggerFactory.getLogger(Purchase.class);
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    Function<Product,BigDecimal> purchaseVatFunction = (product) -> round(product.getPrice()
            .multiply(product.getVatPercentage().add(product.isImported() ? new BigDecimal("5.0"): BigDecimal.ZERO)).divide(ONE_HUNDRED));


    private Product product;
    private int quantity;


    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal calcPurchaseVat() {
        BigDecimal productVat = purchaseVatFunction.apply(this.getProduct());
        logger.info("{} {} : {}",this.getQuantity(),this.getProduct().getLabel(),this.getProduct().getPrice().add(productVat));
        return  BigDecimal.valueOf(this.getQuantity()).multiply(productVat);
    }

    private Purchase(Builder builder) {
        this.product = builder.product;
        this.quantity = builder.quantity;
    }

    public static final class Builder {
        private Product product;
        private int quantity;

        public Builder() {
        }

        public Builder withProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Purchase build() {
            return new Purchase(this);
        }
    }

}
