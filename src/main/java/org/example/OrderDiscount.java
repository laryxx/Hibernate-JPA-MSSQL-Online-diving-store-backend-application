package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OrderDiscounts")
public class OrderDiscount {
    @Id
    long Id;

    @Column(name = "discountName")
    String discountName;

    @Column(name = "discountDescription")
    String discountDescription;

    //When none, is of value "default"
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

    @Column(name = "totalInitialPriceThreshold")
    int totalInitialPriceThreshold;

    @Column(name = "isActive")
    boolean isActive;

    @OneToMany(mappedBy = "orderDiscount")
    List<Order> orders;

    public OrderDiscount(){

    }

    public OrderDiscount(String discountName, String discountDescription, String discountCode, boolean isNumeric,
                         int numericDiscount, int percentileDiscount, int numberOfItemsThreshold,
                         int totalInitialPriceThreshold, boolean isActive){
        ArrayList<String> values = new ArrayList<>();
        this.discountName = discountName;
        this.discountDescription = discountDescription;
        this.discountCode = discountCode;
        this.isNumeric = isNumeric;
        this.numericDiscount = numericDiscount;
        this.percentileDiscount = percentileDiscount;
        this.numberOfItemsThreshold = numberOfItemsThreshold;
        this.totalInitialPriceThreshold = totalInitialPriceThreshold;
        this.isActive = isActive;
        values.add(discountName);
        values.add(discountDescription);
        values.add(discountCode);
        values.add(String.valueOf(isNumeric));
        values.add(String.valueOf(numericDiscount));
        values.add(String.valueOf(percentileDiscount));
        values.add(String.valueOf(numberOfItemsThreshold));
        values.add(String.valueOf(totalInitialPriceThreshold));
        values.add(String.valueOf(isActive));
        this.Id = Main.CreateCRC32Id(values);
    }

    public void setId(long id) {
        this.Id = id;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public void setNumberOfItemsThreshold(int numberOfItemsThreshold) {
        this.numberOfItemsThreshold = numberOfItemsThreshold;
    }

    public void setNumeric(boolean numeric) {
        this.isNumeric = numeric;
    }

    public void setNumericDiscount(int numericDiscount) {
        this.numericDiscount = numericDiscount;
    }

    public void setPercentileDiscount(int percentileDiscount) {
        this.percentileDiscount = percentileDiscount;
    }

    public void setTotalInitialPriceThreshold(int totalInitialPriceThreshold) {
        this.totalInitialPriceThreshold = totalInitialPriceThreshold;
    }

    public long getId() {
        return Id;
    }

    public int getNumberOfItemsThreshold() {
        return numberOfItemsThreshold;
    }

    public int getNumericDiscount() {
        return numericDiscount;
    }

    public int getPercentileDiscount() {
        return percentileDiscount;
    }

    public int getTotalInitialPriceThreshold() {
        return totalInitialPriceThreshold;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public String getDiscountName() {
        return discountName;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isNumeric() {
        return isNumeric;
    }

    @Override
    public String toString() {
        return "Order Discount Id: " + getId() + "\n" +
                "Discount Name: " + getDiscountName() + "\n" +
                "Discount Description: " + getDiscountDescription() + "\n" +
                "Discount Code: " + getDiscountCode() + "\n" +
                "Is Numeric: " + isNumeric() + "\n" +
                "Numeric Discount: " + getNumericDiscount() + "\n" +
                "Percentile Discount: " + getPercentileDiscount() + "\n" +
                "Number of Items Threshold: " + getNumberOfItemsThreshold() + "\n" +
                "Total Initial Price Threshold: " + getTotalInitialPriceThreshold() + "\n" +
                "Is Active: " + isActive() + "\n";
    }
}
