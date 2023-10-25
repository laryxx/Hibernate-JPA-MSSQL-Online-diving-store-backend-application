package org.example;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

@Entity
@Table(name = "Transactions")
public class Transaction {
    @Id
    long Id;

    @Column(name = "transactionInitiationDate")
    Date transactionInitiationDate;

    @Column(name = "transactionInitiationTime")
    Time transactionInitiationTime;

    @Column(name = "paymentDetailsHash")
    String paymentDetailsHash;

    @Column(name = "transactionStatus")
    //Failed, Pending, Successful
    String transactionStatus;

    @OneToOne
    @JoinColumn(name = "order_Id")
    Order order;

    public Transaction(){

    }

    public Transaction(Order order, Date transactionInitiationDate, Time transactionInitiationTime,
                       String paymentDetailsHash, String transactionStatus){
        ArrayList<String> values = new ArrayList<>();
        this.order = order;
        this.transactionInitiationDate = transactionInitiationDate;
        this.transactionInitiationTime = transactionInitiationTime;
        this.paymentDetailsHash = paymentDetailsHash;
        this.transactionStatus = transactionStatus;
        this.Id = Main.CreateCRC32Id(values);
    }


    public void setPaymentDetailsHash(String paymentDetailsHash) {
        this.paymentDetailsHash = paymentDetailsHash;
    }

    public void setTransactionInitiationDate(Date transactionInitiationDate) {
        this.transactionInitiationDate = transactionInitiationDate;
    }

    public void setTransactionInitiationTime(Time transactionInitiationTime) {
        this.transactionInitiationTime = transactionInitiationTime;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public long getId() {
        return Id;
    }

    public Date getTransactionInitiationDate() {
        return transactionInitiationDate;
    }

    public String getPaymentDetailsHash() {
        return paymentDetailsHash;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public Time getTransactionInitiationTime() {
        return transactionInitiationTime;
    }

    @Override
    public String toString() {
        return "Transaction Id: " + getId() + "\n" +
                "Order Key: " + getOrder().toString() + "\n" +
                "Transaction Initiation Date: " + getTransactionInitiationDate() + "\n" +
                "Transaction Initiation Time: " + getTransactionInitiationTime() + "\n" +
                "Payment Details Hash: " + getPaymentDetailsHash() + "\n" +
                "Transaction Status: " + getTransactionStatus() + "\n";
    }
}
