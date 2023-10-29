package org.example;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    long Id;

    @Column(name = "orderPlacementDate")
    Date orderPlacementDate;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_Id")
    Customer customer;

    @Column(name = "totalNumberOfItems")
    int totalNumberOfItems;

    @ManyToOne(targetEntity = OrderDiscount.class)
    @JoinColumn(name = "orderDiscount_Id")
    OrderDiscount orderDiscount;

    @OneToOne(targetEntity = Transaction.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_Id")
    Transaction transaction;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderLine> orderLines;

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
    public Order(Customer customer, Date orderPlacementDate, int totalNumberOfItems, OrderDiscount orderDiscount,
                 int actualTotalPrice, int discountFreeTotalPrice, int orderDiscountFreeTotalPrice,
                 int itemDiscountsFreeTotalPrice, String orderStatus, Transaction transaction){
        ArrayList<String> values = new ArrayList<>();
        this.orderPlacementDate = orderPlacementDate;
        this.customer = customer;
        this.totalNumberOfItems = totalNumberOfItems;
        this.orderDiscount = orderDiscount;
        this.actualTotalPrice = actualTotalPrice;
        this.discountFreeTotalPrice = discountFreeTotalPrice;
        this.orderDiscountFreeTotalPrice = orderDiscountFreeTotalPrice;
        this.itemDiscountsFreeTotalPrice = itemDiscountsFreeTotalPrice;
        this.orderStatus = orderStatus;
        values.add(String.valueOf(orderPlacementDate));
        values.add(String.valueOf(totalNumberOfItems));
        values.add(String.valueOf(orderDiscount));
        values.add(String.valueOf(actualTotalPrice));
        values.add(String.valueOf(discountFreeTotalPrice));
        values.add(String.valueOf(orderDiscountFreeTotalPrice));
        values.add(String.valueOf(itemDiscountsFreeTotalPrice));
        values.add(String.valueOf(orderStatus));
        this.Id = Main.CreateCRC32Id(values);
        this.transaction = transaction;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setActualTotalPrice(int actualTotalPrice) {
        this.actualTotalPrice = actualTotalPrice;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDiscountFreeTotalPrice(int discountFreeTotalPrice) {
        this.discountFreeTotalPrice = discountFreeTotalPrice;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void setItemDiscountsFreeTotalPrice(int itemDiscountsFreeTotalPrice) {
        this.itemDiscountsFreeTotalPrice = itemDiscountsFreeTotalPrice;
    }

    public void setOrderDiscountFreeTotalPrice(int orderDiscountFreeTotalPrice) {
        this.orderDiscountFreeTotalPrice = orderDiscountFreeTotalPrice;
    }

    public void setOrderDiscount(OrderDiscount orderDiscount) {
        this.orderDiscount = orderDiscount;
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

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
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

    public Customer getCustomer() {
        return customer;
    }

    public OrderDiscount getOrderDiscount() {
        return orderDiscount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return  "Order Id: " + getId() + "\n" +
                "Order Placement Date: " + getOrderPlacementDate() + "\n" +
                "Customer Key: " + getCustomer() + "\n" +
                "Total Number Of Items: " + getTotalNumberOfItems() + "\n" +
                //"Order Discount: " + getOrderDiscount().toString() + "\n" +
                "Actual Total Price: " + getActualTotalPrice() + "\n" +
                "Discount Free Total Price: " + getDiscountFreeTotalPrice() + "\n" +
                "Order Discount Free Total Price: " + getOrderDiscountFreeTotalPrice() + "\n" +
                "Item Discounts Free Total Price: " + getItemDiscountsFreeTotalPrice() + "\n" +
                "Order Status: " + getOrderStatus() + "\n";
    }
}
