package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ItemDiscounts")
public class ItemDiscount {
    @Id
    long Id;
//    @Column(name = "productKey")
//    long productKey;
    @OneToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_Id")
    Product product;

    @OneToMany(mappedBy = "itemDiscount")
    List<OrderLine> orderLines;

    @Column(name = "discountName")
    String discountName;

    @Column(name = "discountDescription")
    String discountDescription;

    //When none is of value "default"
    @Column(name = "discountCode")
    String discountCode;

    @Column(name = "isNumeric")
    boolean isNumeric;

    @Column(name = "numericDiscount")
    int numericDiscount;

    @Column(name = "percentileDiscount")
    int percentileDiscount;

    @Column(name = "numberOfItemsThreshold")
    int numberOfItemsThreshold;

    @Column(name = "isActive")
    boolean isActive;

    public ItemDiscount(){

    }

    public ItemDiscount(Product product, String discountName, String discountDescription, String discountCode,
                        boolean isNumeric, int numericDiscount, int percentileDiscount, int numberOfItemsThreshold,
                        boolean isActive){
        ArrayList<String> values = new ArrayList<>();
        this.product = product;
        this.discountName = discountName;
        this.discountDescription = discountDescription;
        this.discountCode = discountCode;
        this.isNumeric = isNumeric;
        this.numericDiscount = numericDiscount;
        this.percentileDiscount = percentileDiscount;
        this.numberOfItemsThreshold = numberOfItemsThreshold;
        this.isActive = isActive;
        values.add(discountName);
        values.add(discountDescription);
        values.add(discountCode);
        values.add(String.valueOf(isNumeric));
        values.add(String.valueOf(numericDiscount));
        values.add(String.valueOf(percentileDiscount));
        values.add(String.valueOf(numberOfItemsThreshold));
        values.add(String.valueOf(isActive));
        this.Id = Main.CreateCRC32Id(values);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPercentileDiscount(int percentileDiscount) {
        this.percentileDiscount = percentileDiscount;
    }

    public void setNumericDiscount(int numericDiscount) {
        this.numericDiscount = numericDiscount;
    }

    public void setNumeric(boolean numeric) {
        this.isNumeric = numeric;
    }

    public void setNumberOfItemsThreshold(int numberOfItemsThreshold) {
        this.numberOfItemsThreshold = numberOfItemsThreshold;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public Product getProduct() {
        return product;
    }

    public long getId() {
        return Id;
    }

    public String getDiscountName() {
        return discountName;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public int getPercentileDiscount() {
        return percentileDiscount;
    }

    public int getNumericDiscount() {
        return numericDiscount;
    }

    public int getNumberOfItemsThreshold() {
        return numberOfItemsThreshold;
    }

    public boolean isNumeric() {
        return isNumeric;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return  "Item Discount Id: " + getId() + "\n" +
                "Product Key: " + getProduct().toString() + "\n" +
                "Discount Name: " + getDiscountName() + "\n" +
                "Discount Description: " + getDiscountDescription() + "\n" +
                "Discount Code: " + getDiscountCode() + "\n" +
                "Is Numeric: " + isNumeric() + "\n" +
                "Numeric Discount: " + getNumericDiscount() + "\n" +
                "Percentile Discount: " + getPercentileDiscount() + "\n" +
                "Number of Items Threshold: " + getNumberOfItemsThreshold() + "\n" +
                "Is Active: " + isActive() + "\n";
    }
}

