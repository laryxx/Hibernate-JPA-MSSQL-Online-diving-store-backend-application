package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Transactions")
public class Transaction {
    @Id
    long Id;

    @Column(name = "orderKey")
    long orderKey;

    @Column(name = "transactionInitiationDate")
    Date transactionInitiationDate;

    @Column(name = "transactionInitiationTime")
    Time transactionInitiationTime;

    @Column(name = "paymentDetailsHash")
    String paymentDetailsHash;

    @Column(name = "")
    //Failed, Pending, Successful
    String status;

}
