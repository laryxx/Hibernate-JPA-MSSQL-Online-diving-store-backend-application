package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "OrderLines")
public class OrderLine {
    @Id
    long Id;

    @Column(name = "orderKey")
    long orderKey;

    @Column(name = "productKey")
    long productKey;

    @Column(name = "unitPrice")
    int unitPrice;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "totalPrice")
    int totalPrice;

    @Column(name = "discountFreeTotalPrice")
    int discountFreeTotalPrice;

    //Nullable
    @Column(name = "itemDiscountKey")
    long itemDiscountKey;

    public OrderLine(){

    }

    public OrderLine(long orderKey, long productKey, int unitPrice, int quantity, int totalPrice,
                     int discountFreeTotalPrice, long itemDiscountKey){
        ArrayList<String> values = new ArrayList<>();
        this.orderKey = orderKey;
        this.productKey = productKey;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.discountFreeTotalPrice = discountFreeTotalPrice;
        this.itemDiscountKey = itemDiscountKey;
        values.add(String.valueOf(orderKey));
        values.add(String.valueOf(productKey));
        values.add(String.valueOf(unitPrice));
        values.add(String.valueOf(totalPrice));
        values.add(String.valueOf(discountFreeTotalPrice));
        values.add(String.valueOf(itemDiscountKey));
        this.Id = Main.CreateCRC32Id(values);
    }

    public void setId(long id) {
        Id = id;
    }

    public void setDiscountFreeTotalPrice(int discountFreeTotalPrice) {
        this.discountFreeTotalPrice = discountFreeTotalPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setItemDiscountKey(long itemDiscountKey) {
        this.itemDiscountKey = itemDiscountKey;
    }

    public void setOrderKey(long orderKey) {
        this.orderKey = orderKey;
    }

    public void setProductKey(long productKey) {
        this.productKey = productKey;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return Id;
    }

    public int getDiscountFreeTotalPrice() {
        return discountFreeTotalPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public long getItemDiscountKey() {
        return itemDiscountKey;
    }

    public long getOrderKey() {
        return orderKey;
    }

    public long getProductKey() {
        return productKey;
    }

    @Override
    public String toString() {
        return  "Order Line Id: " + getId() + "\n" +
                "Order Key: " + getOrderKey() + "\n" +
                "Product Key: " + getProductKey() + "\n" +
                "Unit Price: " + getUnitPrice() + "\n" +
                "Quantity: " + getQuantity() + "\n" +
                "Total Price: " + getTotalPrice() + "\n" +
                "Discount Free Total Price: " + getDiscountFreeTotalPrice() + "\n" +
                "Item Discount Key: " + getItemDiscountKey() + "\n";
    }
}
