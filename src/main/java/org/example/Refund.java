package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "Refunds")
public class Refund {
    @Id
    long Id;

//    @Column(name = "customerKey")
//    long customerKey;
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_Id")
    Customer customer;

    @OneToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_Id")
    Order order;

    @Column(name = "description")
    String description;

    @Column(name = "pricePercentage")
    int pricePercentage;

    public Refund(){

    }

    public Refund(long Id, Customer customer, Order order, String description, int pricePercentage){
        ArrayList<String> values = new ArrayList<>();
        this.customer = customer;
        this.order = order;
        this.description = description;
        this.pricePercentage = pricePercentage;
        values.add(String.valueOf(Id));
        values.add(String.valueOf(customer));
        values.add(String.valueOf(order));
        values.add(description);
        values.add(String.valueOf(pricePercentage));
        this.Id = Main.CreateCRC32Id(values);
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPricePercentage(int pricePercentage) {
        this.pricePercentage = pricePercentage;
    }

    public Order getOrder() {
        return order;
    }

    public long getId() {
        return Id;
    }

    public Customer getCustomer() {
        return customer;
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
                "Customer Key: " + getCustomer().toString() + "\n" +
                "Order Key: " + getOrder().toString() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Price Percentage: " + getPricePercentage() + "\n";
    }
}
