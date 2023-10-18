package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.ArrayList;

//TODO
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    long Id;

    @Column(name = "orderPlacementDate")
    Date orderPlacementDate;

    @Column(name = "customerKey")
    long customerKey;

    @Column(name = "totalNumberOfItems")
    int totalNumberOfItems;

    @Column(name = "orderDiscountKey")
    long orderDiscountKey;

    @Column(name = "actualTotalPrice")
    int actualTotalPrice;

    @Column(name = "discountFreeTotalPrice")
    int discountFreeTotalPrice;

    @Column(name = "orderDiscountFreeTotalPrice")
    int orderDiscountFreeTotalPrice;

    @Column(name = "itemDiscountsFreeTotalPrice")
    int itemDiscountsFreeTotalPrice;

    //Completed, Pending payment, Cancelled, Refunded, Pending refund
    @Column(name = "orderStatus")
    String orderStatus;

    public Order(){

    }
    public Order(long Id, Date orderPlacementDate, long customerKey, int totalNumberOfItems, long orderDiscountKey,
                 int actualTotalPrice, int discountFreeTotalPrice, int orderDiscountFreeTotalPrice,
                 int itemDiscountsFreeTotalPrice, String orderStatus){
        ArrayList<String> values = new ArrayList<>();
        this.orderPlacementDate = orderPlacementDate;
        this.customerKey = customerKey;
        this.totalNumberOfItems = totalNumberOfItems;
        this.orderDiscountKey = orderDiscountKey;
        this.actualTotalPrice = actualTotalPrice;
        this.discountFreeTotalPrice = discountFreeTotalPrice;
        this.orderDiscountFreeTotalPrice = orderDiscountFreeTotalPrice;
        this.itemDiscountsFreeTotalPrice = itemDiscountsFreeTotalPrice;
        this.orderStatus = orderStatus;
        values.add(String.valueOf(orderPlacementDate));
        values.add(String.valueOf(customerKey));
        values.add(String.valueOf(totalNumberOfItems));
        values.add(String.valueOf(orderDiscountKey));
        values.add(String.valueOf(actualTotalPrice));
        values.add(String.valueOf(discountFreeTotalPrice));
        values.add(String.valueOf(orderDiscountFreeTotalPrice));
        values.add(String.valueOf(itemDiscountsFreeTotalPrice));
        values.add(String.valueOf(orderStatus));
        this.Id = Main.CreateCRC32Id(values);
    }

    public void setId(long id) {
        Id = id;
    }

    public void setActualTotalPrice(int actualTotalPrice) {
        this.actualTotalPrice = actualTotalPrice;
    }

    public void setCustomerKey(long customerKey) {
        this.customerKey = customerKey;
    }

    public void setDiscountFreeTotalPrice(int discountFreeTotalPrice) {
        this.discountFreeTotalPrice = discountFreeTotalPrice;
    }

    public void setItemDiscountsFreeTotalPrice(int itemDiscountsFreeTotalPrice) {
        this.itemDiscountsFreeTotalPrice = itemDiscountsFreeTotalPrice;
    }

    public void setOrderDiscountFreeTotalPrice(int orderDiscountFreeTotalPrice) {
        this.orderDiscountFreeTotalPrice = orderDiscountFreeTotalPrice;
    }

    public void setOrderDiscountKey(long orderDiscountKey) {
        this.orderDiscountKey = orderDiscountKey;
    }

    public void setOrderPlacementDate(Date orderPlacementDate) {
        this.orderPlacementDate = orderPlacementDate;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotalNumberOfItems(int totalNumberOfItems) {
        this.totalNumberOfItems = totalNumberOfItems;
    }

    public long getId() {
        return Id;
    }

    public Date getOrderPlacementDate() {
        return orderPlacementDate;
    }

    public int getActualTotalPrice() {
        return actualTotalPrice;
    }

    public int getDiscountFreeTotalPrice() {
        return discountFreeTotalPrice;
    }

    public int getItemDiscountsFreeTotalPrice() {
        return itemDiscountsFreeTotalPrice;
    }

    public int getOrderDiscountFreeTotalPrice() {
        return orderDiscountFreeTotalPrice;
    }

    public int getTotalNumberOfItems() {
        return totalNumberOfItems;
    }

    public long getCustomerKey() {
        return customerKey;
    }

    public long getOrderDiscountKey() {
        return orderDiscountKey;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return  "Order Id: " + getId() + "\n" +
                "Order Placement Date: " + getOrderPlacementDate() + "\n" +
                "Customer Key: " + getCustomerKey() + "\n" +
                "Total Number Of Items: " + getTotalNumberOfItems() + "\n" +
                "Order Discount Key: " + getOrderDiscountKey() + "\n" +
                "Actual Total Price: " + getActualTotalPrice() + "\n" +
                "Discount Free Total Price: " + getDiscountFreeTotalPrice() + "\n" +
                "Order Discount Free Total Price: " + getOrderDiscountFreeTotalPrice() + "\n" +
                "Item Discounts Free Total Price: " + getItemDiscountsFreeTotalPrice() + "\n" +
                "Order Status: " + getOrderStatus() + "\n";
    }
}
