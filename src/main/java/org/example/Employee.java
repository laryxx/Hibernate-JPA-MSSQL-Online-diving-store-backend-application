package org.example;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    long Id;

    @Column(name="employeeFullName")
    String fullName;

    @Column(name="employeeFirstName")
    String firstName;

    @Column(name="employeeMiddleName")
    String middleName;

    @Column(name="employeeLastName")
    String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name="birthDate")
    Date birthDate;

    @Temporal(TemporalType.DATE)
    @Column(name="employmentDate")
    Date employmentDate;

    @Column(name="yearSalary")
    int yearSalary;

    //male, female, other
    @Column(name="employeeGender")
    String gender;

    @Column(name="employeeEmail")
    String email;

    //active, on leave, or terminated.
    @Column(name="employeeStatus")
    String status;

    //HR, Sales, IT, Finance, Marketing, Customer Service, PR
    @Column(name="employeeDepartment")
    String department;

    public Employee(){

    }

    public Employee(String firstName, String middleName, String lastName, Date birthDate, Date employmentDate,
                    int yearSalary, String gender, String email, String status, String department){
        //Date date = java.sql.Date.valueOf("1995-07-01");
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullName = Main.createName(firstName, middleName, lastName);
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.yearSalary = yearSalary;
        this.gender = gender;
        this.email = email;
        this.status = status;
        this.department = department;
        ArrayList<String> values = new ArrayList<>();
        values.add(firstName);
        values.add(middleName);
        values.add(lastName);
        values.add(String.valueOf(yearSalary));
        values.add(gender);
        values.add(email);
        values.add(status);
        values.add(department);
        this.Id = Main.CreateCRC32Id(values);
    }

    public void setId(long id) {
        Id = id;
    }

    public void setYearSalary(int yearSalary) {
        this.yearSalary = yearSalary;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return Id;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getYearSalary() {
        return yearSalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Employee Id: " + this.getId() + "\n" +
                "Employee Full Name: " + this.getFullName() + "\n" +
                "Employee Birth Date: " + this.getBirthDate() + "\n" +
                "Employee Yearly Salary: $" + this.getYearSalary() + "\n" +
                "Employee Gender: " + this.getGender() + "\n" +
                "Employee Email: " + this.getEmail() + "\n" +
                "Employee Status: " + this.getStatus() + "\n" +
                "Employee Department: " + this.getDepartment() + "\n" +
                "Employee Employment Date: " + this.getEmploymentDate();
    }
}
