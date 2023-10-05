package org.example;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.zip.CRC32;

@Entity
@Table(name = "Users")
public class User {
    @Id
    Long Id;
    @Column(name="fullName")
    String fullName;
    @Column(name="firstName")
    String firstName;
    @Column(name="middleName")
    String middleName;
    @Column(name="lastName")
    String lastName;
    @Column(name="birthDate")
    String birthDate;
    @Column(name="joinDate")
    String joinDate;
    @Column(name="yearSalary")
    int yearSalary;
    @Column(name="numberOfCars")
    int numberOfCars;
    @Column(name="numberOfChildren")
    int numberOfChildren;
    @Column(name="numberOfTransactions")
    int numberOfTransactions;

    public User(String firstName, String middleName, String lastName, int birthYear, int birthMonth, int birthDay,
                int joinYear, int joinMonth, int joinDay, int yearSalary, int numberOfCars, int numberOfChildren){
        this.fullName = CreateName(firstName, middleName, lastName);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = CreateDate(birthYear, birthMonth, birthDay);
        this.joinDate = CreateDate(joinYear, joinMonth, joinDay);
        ArrayList<String> values = new ArrayList<>();
        values.add(firstName);
        values.add(middleName);
        values.add(lastName);
        values.add(this.birthDate);
        values.add(this.joinDate);
        //values.add(generateRandomString());
        this.Id = Main.CreateCRC32Id(values);
        //this.id = CreateCRC32Id(values);
        this.yearSalary = yearSalary;
        this.numberOfCars = numberOfCars;
        this.numberOfChildren = numberOfChildren;
        this.numberOfTransactions = 0;
    }

    public User() {

    }

    public static String CreateName(String firstName, String middleName, String lastName){
        if(middleName.length() > 0) {
            return firstName + " " + middleName + " " + lastName;
        }
        else{
            return firstName + " " + lastName;
        }
    }

    public static String CreateDate(int year, int month, int day){
        return String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void setNumberOfTransactions(int numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public void setYearSalary(int yearSalary) {
        this.yearSalary = yearSalary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public long getId() {
        return Id;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public int getYearSalary() {
        return yearSalary;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        return "first Name: " + this.firstName + "\n" +
                "middle Name: " + this.middleName + "\n" +
                "last Name: " + this.lastName + "\n" +
                "full Name: " + this.fullName + "\n" +
                "birth Date: " + this.birthDate + "\n" +
                "join Date: " + this.joinDate + "\n" +
                "year Salary: " + this.yearSalary + "\n" +
                "number of Cars: " + this.numberOfCars + "\n" +
                "number of Children: " + this.numberOfChildren + "\n" +
                "number of Transactions: " + this.numberOfTransactions + "\n";
    }
}



