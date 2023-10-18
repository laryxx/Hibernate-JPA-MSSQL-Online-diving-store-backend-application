package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "Refunds")
public class Refund {
    @Id
    long Id;

    @Column(name = "customerKey")
    long customerKey;

    @Column(name = "orderKey")
    long orderKey;

    @Column(name = "description")
    String description;

    @Column(name = "pricePercentage")
    int pricePercentage;

    public Refund(){

    }

    public Refund(long Id, long customerKey, long orderKey, String description, int pricePercentage){
        ArrayList<String> values = new ArrayList<>();
        this.customerKey = customerKey;
        this.orderKey = orderKey;
        this.description = description;
        this.pricePercentage = pricePercentage;
        values.add(String.valueOf(Id));
        values.add(String.valueOf(customerKey));
        values.add(String.valueOf(orderKey));
        values.add(description);
        values.add(String.valueOf(pricePercentage));
        this.Id = Main.CreateCRC32Id(values);
    }

    public void setOrderKey(long orderKey) {
        this.orderKey = orderKey;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setCustomerKey(long customerKey) {
        this.customerKey = customerKey;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPricePercentage(int pricePercentage) {
        this.pricePercentage = pricePercentage;
    }

    public long getOrderKey() {
        return orderKey;
    }

    public long getId() {
        return Id;
    }

    public long getCustomerKey() {
        return customerKey;
    }

    public String getDescription() {
        return description;
    }

    public int getPricePercentage() {
        return pricePercentage;
    }

    @Override
    public String toString() {
        return "Refund Id: " + getId() + "\n" +
                "Customer Key: " + getCustomerKey() + "\n" +
                "Order Key: " + getOrderKey() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Price Percentage: " + getPricePercentage() + "\n";
    }
}
