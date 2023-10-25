package org.example;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Customers")
public class Customer {
    @Id
    long Id;

    @Column(name="customerFullName")
    String customerFullName;

    @Column(name="customerFirstName")
    String customerFirstName;

    @Column(name="customerMiddleName")
    String customerMiddleName;

    @Column(name="customerLastName")
    String customerLastName;

    @Temporal(TemporalType.DATE)
    @Column(name="birthDate")
    Date birthDate;

    @Temporal(TemporalType.DATE)
    @Column(name="registrationDate")
    Date registrationDate;

    @Column(name = "customerEmail")
    String customerEmail;

    @Column(name = "customerLogin")
    String login;

    @Column(name = "passwordHash")
    String passwordHash;

    @Column(name="customerPhoneNumber")
    String customerPhoneNumber;

    @Column(name="customerGender")
    String customerGender;

    @OneToMany(mappedBy = "customer")
    List<Order> orders;

    @OneToMany(mappedBy = "customer")
    List<Refund> refunds;

    public Customer(){

    }

    public Customer(String customerFirstName, String customerMiddleName, String customerLastName, Date birthDate,
                    Date registrationDate, String customerEmail, String login, String passwordHash,
                    String customerPhoneNumber, String customerGender){
        this.customerFullName = Main.createName(customerFirstName, customerMiddleName, customerLastName);
        this.customerFirstName = customerFirstName;
        this.customerMiddleName = customerMiddleName;
        this.customerLastName = customerLastName;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.customerEmail = customerEmail;
        this.login = login;
        this.passwordHash = passwordHash;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerGender = customerGender;
        ArrayList<String> values = new ArrayList<>();
        values.add(customerFullName);
        values.add(String.valueOf(birthDate));
        values.add(String.valueOf(registrationDate));
        values.add(customerEmail);
        values.add(login);
        values.add(passwordHash);
        values.add(customerPhoneNumber);
        this.Id = Main.CreateCRC32Id(values);
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public void setCustomerMiddleName(String customerMiddleName) {
        this.customerMiddleName = customerMiddleName;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public long getId() {
        return Id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerMiddleName() {
        return customerMiddleName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Customer Id: " + this.getId() + "\n" +
                "Customer Full Name: " + this.getCustomerFullName() + "\n" +
                "Customer Birth Date: " + this.getBirthDate() + "\n" +
                "Customer Registration Date: " + this.getRegistrationDate() + "\n" +
                "Customer Email: " + this.getCustomerEmail() + "\n" +
                "Customer Login: " + this.getLogin() + "\n" +
                "Customer Password Hash: " + this.getPasswordHash() + "\n" +
                "Customer Phone Number: " + this.getCustomerPhoneNumber() + "\n" +
                "Customer Gender: " + this.getCustomerGender() + "\n";
    }
}
