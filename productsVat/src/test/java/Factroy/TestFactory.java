package Factroy;

import domain.Product;
import domain.ProductType;
import domain.Purchase;

public class TestFactory {

    public static Purchase.Builder aPurchase(){
        return new Purchase.Builder()
                .withQuantity(1);
    }

    public static Product.Builder aBook(){
        return new Product.Builder()
                .withProductType(ProductType.Book)
                .withLabel("livre");
    }

    public static Product.Builder aCD(){
        return new Product.Builder()
                .withProductType(ProductType.Miscellaneous)
                .withLabel("CD musical");
    }

    public static Product.Builder aChocolateBar(){
        return new Product.Builder()
                .withProductType(ProductType.Food)
                .withLabel("barre de chocolat");
    }

    public static Product.Builder anImportedChocolateBox(){
        return new Product.Builder()
                .withProductType(ProductType.Food)
                .withLabel("boîte de chocolats importée")
                .withIsImported(true);
    }

    public static Product.Builder anImportedParfum(){
        return new Product.Builder()
                .withProductType(ProductType.Miscellaneous)
                .withLabel("flacon de parfum importé")
                .withIsImported(true)
                .withIsImported(true);
    }

    public static Product.Builder aParfum(){
        return new Product.Builder()
                .withProductType(ProductType.Miscellaneous)
                .withLabel("flacon de parfum");
    }

    public static Product.Builder aDrug(){
        return new Product.Builder()
                .withProductType(ProductType.Drugs)
                .withLabel("boîte de pilules contre la migraine");
    }



}

