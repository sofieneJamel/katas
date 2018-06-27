package domain;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

public class Product {

    private BigDecimal price;
    private String label;
    private ProductType productType;
    private boolean isImported;

    private Product(Builder builder) {
        price = builder.price;
        label = builder.label;
        productType = builder.productType;
        isImported = builder.isImported;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getLabel() {
        return label;
    }

    public ProductType getProductType() {
        return productType;
    }

    public BigDecimal getVatPercentage() {
        return productType.getVatPercentage();
    }

    public boolean isImported() {
        return isImported;
    }


    public static final class Builder {
        private BigDecimal price;
        private String label;
        private ProductType productType;
        private boolean isImported;

        public Builder() {
        }

        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder withLabel(String label) {
            this.label = label;
            return this;
        }

        public Builder withProductType(ProductType productType) {
            this.productType = productType;
            return this;
        }

        public Builder withIsImported(boolean isImported) {
            this.isImported = isImported;
            return this;
        }

        public Product build() {
            checkArgument(price != null && price.compareTo(BigDecimal.ZERO) > 0,"price value could not be null,zero or negative");
            checkArgument(productType != null, "productType could not be null");
            return new Product(this);
        }

    }
}
