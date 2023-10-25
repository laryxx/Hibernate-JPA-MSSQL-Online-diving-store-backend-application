package org.example;

import jdk.jfr.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.zip.CRC32;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            populateItemDiscounts(session);

            // Commit the transaction
            transaction.commit();
        }
    }

    //Use this to populate itemDiscounts table with 2 unique discounts
    public static void populateItemDiscounts(Session session){
        ItemDiscount itemDiscount1 = new ItemDiscount(getProductById(210708959, session), "EmeraldEyes double-lens mask offer",
                "A special offer made to customers who purchase the EmeraldEyes double-lens mask",
                "DUOS-LOOK_EYES", false, 0, 10, 1,
                true);
        ItemDiscount itemDiscount2 = new ItemDiscount(getProductById(2637510573L, session), "AquaPro Sapphireseal Wetsuit discount",
                "A special offer made to customers who purchase the AquaPro Sapphireseal Wetsuit",
                "AQUA-SUIT_DONE", false, 0, 10, 1,
                true);
        saveItemDiscount(itemDiscount1, session);
        saveItemDiscount(itemDiscount2, session);
    }

    //Use this to populate orderDiscounts table with 3 unique discounts
    public static void populateOrderDiscounts(Session session){
        OrderDiscount orderDiscount1 = new OrderDiscount("Regular Customer",
                "A special discount offer made to customers who've spent more than 1000USD",
                "CUBE-DIVE-MILE", false, 0, 7, 0,
                150, true);
        OrderDiscount orderDiscount2 = new OrderDiscount("Big Purchase",
                "A special discount offer made to customers placing an order more than 350USD",
                "FALL-RISE-BEAT", true, 50, 0, 0,
                350, true);
        OrderDiscount orderDiscount3 = new OrderDiscount("Many items purchase",
                "A special discount offer made to customers placing an order with more than 5 items",
                "ROLL-BEAM-LONG", true, 20, 0, 5,
                25, true);
        saveOrderDiscount(orderDiscount1, session);
        saveOrderDiscount(orderDiscount2, session);
        saveOrderDiscount(orderDiscount3, session);
    }

    //Use this to generate n semi-randomly generated users and populate the Users table
    public static void populateUsers(int number, Session session){
        for(int i = 0; i < number; i++){
            User user = generateSemiRandomUser();
            System.out.println(user.toString());
            saveUser(user, session);
        }
    }

    //Use this to generate n semi-randomly generated customers and populate the Customers table
    public static void populateCustomers(int number, Session session){
        for(int i = 0; i < number; i++){
            Customer customer = generateSemiRandomCustomer();
            System.out.println(customer.toString());
            saveCustomer(customer, session);
        }
    }

    //Use this to generate n semi-randomly generated employees and populate the Employees table
    public static void populateEmployees(int number, Session session){
        for(int i = 0; i < number; i++){
            Employee employee = generateSemiRandomEmployee();
            System.out.println(employee.toString());
            saveEmployee(employee, session);
        }
    }

    //Use this to populate Categories, Subcategories and Products tables
    public static void populateProducts(Session session){
        ProductCategory productCategory1 = new ProductCategory("Wetsuits");
        ProductCategory productCategory2 = new ProductCategory("Diving Masks");
        ProductCategory productCategory3 = new ProductCategory("Fins");
        ProductCategory productCategory4 = new ProductCategory("Regulators");
        ProductCategory productCategory5 = new ProductCategory("Buoyancy Control Devices");
        ProductCategory productCategory6 = new ProductCategory("Dive Computers");
        ProductCategory productCategory7 = new ProductCategory("Dive Lights");

        saveCategory(productCategory1, session);
        saveCategory(productCategory2, session);
        saveCategory(productCategory3, session);
        saveCategory(productCategory4, session);
        saveCategory(productCategory5, session);
        saveCategory(productCategory6, session);
        saveCategory(productCategory7, session);

        ProductSubcategory productSubcategory1 = new ProductSubcategory("Full Wetsuits", productCategory1);
        ProductSubcategory productSubcategory2 = new ProductSubcategory("Shorty Wetsuits", productCategory1);

        ProductSubcategory productSubcategory3 = new ProductSubcategory("Single Lens Masks", productCategory2);
        ProductSubcategory productSubcategory4 = new ProductSubcategory("Double Lens Masks", productCategory2);

        ProductSubcategory productSubcategory5 = new ProductSubcategory("Full Foot Fins", productCategory3);
        ProductSubcategory productSubcategory6 = new ProductSubcategory("Open Heel Fins", productCategory3);

        ProductSubcategory productSubcategory7 = new ProductSubcategory("First Stage Regulators", productCategory4);
        ProductSubcategory productSubcategory8 = new ProductSubcategory("Second Stage Regulators", productCategory4);

        ProductSubcategory productSubcategory9 = new ProductSubcategory("Back Inflation BCDs", productCategory5);
        ProductSubcategory productSubcategory10 = new ProductSubcategory("Jacket Style BCDs", productCategory5);

        ProductSubcategory productSubcategory11 = new ProductSubcategory("Wrist-Mounted Dive Computers", productCategory6);

        ProductSubcategory productSubcategory12 = new ProductSubcategory("Primary Dive Lights", productCategory7);

        saveSubcategory(productSubcategory1, session);
        saveSubcategory(productSubcategory2, session);
        saveSubcategory(productSubcategory3, session);
        saveSubcategory(productSubcategory4, session);
        saveSubcategory(productSubcategory5, session);
        saveSubcategory(productSubcategory6, session);
        saveSubcategory(productSubcategory7, session);
        saveSubcategory(productSubcategory8, session);
        saveSubcategory(productSubcategory9, session);
        saveSubcategory(productSubcategory10, session);
        saveSubcategory(productSubcategory11, session);
        saveSubcategory(productSubcategory12, session);

        Product product1 = new Product("Rubyshark", 200, "Black", productSubcategory1, 100, "Divers Inc", "DiverWear");
        Product product2 = new Product("Sapphireseal", 220, "Blue", productSubcategory1, 110, "Ocean Gear", "AquaPro");
        Product product3 = new Product("Crimsonwave", 150, "Red", productSubcategory2, 75, "Dive World", "AquaFlex");
        Product product4 = new Product("Goldenfin", 180, "Yellow", productSubcategory2, 90, "Deep Dive Imports", "Neptune");
        Product product5 = new Product("Clearview", 50, "Clear", productSubcategory3, 25, "Divers Inc", "SeaVision");
        Product product6 = new Product("Blackgaze", 45, "Black", productSubcategory3, 22, "Ocean Gear", "AquaView");
        Product product7 = new Product("AquaSight", 60, "Blue", productSubcategory4, 30, "Dive World", "DeepSee");
        Product product8 = new Product("EmeraldEyes", 70, "Green", productSubcategory4, 35, "Deep Dive Imports", "CrystalClear");
        Product product9 = new Product("FinMaster Pro", 80, "Black", productSubcategory5, 40, "Divers Inc", "FinMaster");
        Product product10 = new Product("AquaFlex Pro", 70, "Yellow", productSubcategory5, 35, "Ocean Gear", "AquaFin");
        Product product11 = new Product("OceanFlow Pro", 90, "Blue", productSubcategory6, 45, "Dive World", "OceanFlow");
        Product product12 = new Product("FinFlex Pro", 100, "Red", productSubcategory6, 50, "Deep Dive Imports", "FinFlex");
        Product product13 = new Product("AquaPulse X1", 150, "Chrome", productSubcategory7, 75, "Divers Inc", "AquaPulse");
        Product product14 = new Product("ProReg X2", 160, "Silver", productSubcategory7, 80, "Ocean Gear", "ProReg");
        Product product15 = new Product("DiveMate X1", 120, "Black", productSubcategory8, 60, "Dive World", "DiveMate");
        Product product16 = new Product("AquaBreath X2", 140, "Blue", productSubcategory8, 70, "Deep Dive Imports", "AquaBreath");
        Product product17 = new Product("DiveFloat B1", 200, "Red", productSubcategory9, 100, "Divers Inc", "DiveFloat");
        Product product18 = new Product("AquaRise B1", 220, "Green", productSubcategory9, 110, "Ocean Gear", "AquaRise");
        Product product19 = new Product("BCDPro J1", 180, "Blue", productSubcategory10, 90, "Dive World", "BCDPro");
        Product product20 = new Product("AquaFloat J1", 190, "Yellow", productSubcategory10, 95, "Deep Dive Imports", "AquaFloat");
        Product product21 = new Product("DiveMaster C1", 250, "Black", productSubcategory11, 125, "Divers Inc", "DiveMaster");
        Product product22 = new Product("AquaTech C1", 270, "Silver", productSubcategory11, 135, "Ocean Gear", "AquaTech");
        Product product23 = new Product("SeaBeam L1", 100, "Yellow", productSubcategory12, 50, "Dive World", "SeaBeam");
        Product product24 = new Product("AquaGlow L1", 120, "Black", productSubcategory12, 60, "Deep Dive Imports", "AquaGlow");

        saveProduct(product1, session);
        saveProduct(product2, session);
        saveProduct(product3, session);
        saveProduct(product4, session);
        saveProduct(product5, session);
        saveProduct(product6, session);
        saveProduct(product7, session);
        saveProduct(product8, session);
        saveProduct(product9, session);
        saveProduct(product10, session);
        saveProduct(product11, session);
        saveProduct(product12, session);
        saveProduct(product13, session);
        saveProduct(product14, session);
        saveProduct(product15, session);
        saveProduct(product16, session);
        saveProduct(product17, session);
        saveProduct(product18, session);
        saveProduct(product19, session);
        saveProduct(product20, session);
        saveProduct(product21, session);
        saveProduct(product22, session);
        saveProduct(product23, session);
        saveProduct(product24, session);
    }

    public static long CreateCRC32Id(ArrayList<String> values){
        CRC32 crc32 = new CRC32();

        for (String variable : values) {
            crc32.update(variable.getBytes());
        }

        return crc32.getValue();
    }

    public static void printMessage(String message){
        System.out.println("---------");
        System.out.println();
        System.out.println(message);
        System.out.println();
        System.out.println("---------");
    }

    public static void removeUserById(long id, Session session){
        try{
            User user = session.get(User.class, id);
            if(user != null){
                session.remove(user);
                String message = "User with id: " + id + " was removed successfully";
                printMessage(message);
            }
            else{
                String message = "User with id: " + id + " not found, Remove operation cancelled";
                printMessage(message);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Product getProductById(long id, Session session){
        try{
            Product product = session.get(Product.class, id);
            if(product != null){
                return product;
            }
            else{
                String message = "Product with id: " + id + " not found";
                printMessage(message);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void saveItemDiscount(ItemDiscount itemDiscount, Session session){
        if(itemDiscount != null){
            try {
                session.save(itemDiscount);
            } catch (Exception e){
                e.printStackTrace();
            }
            String message = "Item discount with id: " + itemDiscount.getId() + " was saved successfully";
            printMessage(message);
        }
    }

    public static void saveOrderDiscount(OrderDiscount orderDiscount, Session session){
        if(orderDiscount != null){
            try {
                session.save(orderDiscount);
            } catch (Exception e){
                e.printStackTrace();
            }
            String message = "Order discount with id: " + orderDiscount.getId() + " was saved successfully";
            printMessage(message);
        }
    }

    public static void saveProduct(Product product, Session session){
        if(product != null){
            try {
                session.save(product);
            } catch (Exception e){
                e.printStackTrace();
            }
            String message = "Product with id: " + product.getId() + " was saved successfully";
            printMessage(message);
        }
    }

    public static void saveSubcategory(ProductSubcategory productSubcategory, Session session){
        if(productSubcategory != null){
            try {
                session.save(productSubcategory);
            } catch (Exception e){
                e.printStackTrace();
            }
            String message = "Product Subcategory with id: " + productSubcategory.getId() + " was saved successfully";
            printMessage(message);
        }
    }

    public static void saveCategory(ProductCategory productCategory, Session session){
        if(productCategory != null){
            try {
                session.save(productCategory);
            } catch (Exception e){
                e.printStackTrace();
            }
            String message = "Product Category with id: " + productCategory.getId() + " was saved successfully";
            printMessage(message);
        }
    }

    public static void saveUser(User user, Session session){
        if(user != null){
            try {
                session.save(user);
            } catch (Exception e){
                e.printStackTrace();
            }
            String message = "User with id: " + user.getId() + " was saved successfully";
            printMessage(message);
        }
    }

    public static void saveCustomer(Customer customer, Session session){
        if(customer != null){
            try {
                session.save(customer);
            } catch (Exception e){
                e.printStackTrace();
            }
            String message = "Customer with id: " + customer.getId() + " was saved successfully";
            printMessage(message);
        }
    }

    public static void saveEmployee(Employee employee, Session session){
        if(employee != null){
            try {
                session.save(employee);
            } catch (Exception e){
                e.printStackTrace();
            }
            String message = "Employee with id: " + employee.getId() + " was saved successfully";
            printMessage(message);
        }
    }

    public static String getRandomFirstName(){
        List<String> firstNamesList = Arrays.asList("Andrew", "George", "Alex", "Sarah", "Emily", "Michael", "Olivia",
                "James", "Sophia", "William", "Ava", "John", "Mia", "David", "Charlotte", "Benjamin", "Amelia",
                "Christopher", "Harper", "Joseph", "Evelyn", "Daniel", "Abigail", "Matthew", "Elizabeth", "Samuel",
                "Sofia", "Nicholas", "Grace", "Ethan", "Lily", "Christopher", "Chloe", "Joseph", "Scarlett", "Ryan",
                "Ella", "William", "Zoey", "Jonathan", "Addison", "Alexander", "Aubrey", "Nicholas", "Hannah", "Daniel",
                "Scarlett", "Matthew", "Zoe", "Anthony");
        ArrayList<String> firstNames = new ArrayList<String>(firstNamesList);
        return firstNames.get(chooseRandomNumber(firstNames.size()));
    }

    public static String getRandomMiddleName(){
        List<String> middleNamesList = Arrays.asList("James", "Elizabeth", "Michael", "Marie", "William", "Anne",
                "David", "Rose", "John", "Katherine", "Robert", "Louise", "Joseph", "Grace", "Charles", "Mae", "Thomas",
                "Eleanor", "Daniel", "Jane", "Matthew", "Emily", "Andrew", "Claire", "Christopher", "Alice", "Nicholas",
                "Victoria", "Anthony", "Mary", "Steven", "Catherine", "Richard", "Patricia", "Edward", "Laura",
                "Alexander", "Jennifer", "Benjamin", "Helen", "Samuel", "Margaret", "Henry", "Julia", "George", "Lucy",
                "Oliver", "Sofia");
        ArrayList<String> middleNames = new ArrayList<>(middleNamesList);
        Random rand = new Random();
        boolean hasMiddleName = rand.nextBoolean();
        if(hasMiddleName){
            return middleNames.get(chooseRandomNumber(middleNames.size()));
        }
        return "";
    }

    public static String getRandomLastName(){
        List<String> lastNamesList = Arrays.asList("Smith", "Johnson", "Brown", "Davis", "Miller", "Wilson", "Moore",
                "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez",
                "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "Hernandez",
                "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter",
                "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards",
                "Collins", "Stewart");
        ArrayList<String> lastNames = new ArrayList<>(lastNamesList);
        return lastNames.get(chooseRandomNumber(lastNames.size()));
    }

    public static Date generateRandomDate(int minYear, int maxYear) {
        int gap = maxYear - minYear;
        int year = minYear + chooseRandomNumber(gap);
        int month = 1 + chooseRandomNumber(12);
        //this should suffice
        int day = 1 + chooseRandomNumber(25);

        // Ensure proper formatting with leading zeros
        String dateString = String.format("%04d-%02d-%02d", year, month, day);

        // Try to parse the formatted date string into a java.sql.Date
        try {
            return java.sql.Date.valueOf(dateString);
        } catch (IllegalArgumentException e) {
            // Handle invalid date, e.g., if month is 13 or day is 32
            e.printStackTrace(); // or log the error
            return null; // Return null or throw an exception as needed
        }
    }

    public static String getRandomPhoneNumber() {
        Random random = new Random();
        int countryCode = random.nextInt(100) + 30; // Generates a random country code between +30 and +129
        int areaCode = random.nextInt(10000); // Generates a random 4-digit area code
        int subscriberNumber = random.nextInt(10000000); // Generates a random 7-digit subscriber number
        return String.format("+%d %04d %07d", countryCode, areaCode, subscriberNumber);
    }


    public static Customer generateSemiRandomCustomer(){
        String firstName = getRandomFirstName();
        String middleName = getRandomMiddleName();
        String lastName = getRandomLastName();
        Date birthDate = generateRandomDate(1970, 2005);
        Date registrationDate = generateRandomDate(2010, 2022);
        String email = getRandomEmail();
        String login = getRandomString(6);
        String passwordHash = getRandomString(12);
        String phoneNumber = getRandomPhoneNumber();
        String gender = getRandomGender();
        return new Customer(firstName, middleName, lastName, birthDate, registrationDate, email, login, passwordHash,
                phoneNumber, gender);
    }

    public static Employee generateSemiRandomEmployee(){
        String firstName = getRandomFirstName();
        String middleName = getRandomMiddleName();
        String lastName = getRandomLastName();
        Date birthDate = generateRandomDate(1970, 2005);
        Date employmentDate = generateRandomDate(2010, 2022);
        int yearSalary = roundUpToNearestThousand(10000 + chooseRandomNumber(30000));
        String email = getRandomEmail();
        String gender = getRandomGender();
        String status = getRandomStatus();
        //Active, On Leave, Terminated
        String department = getRandomDepartment();
        return new Employee(firstName, middleName, lastName, birthDate, employmentDate, yearSalary, gender, email,
                status, department);
    }

    public static String getRandomStatus(){
        Random rand = new Random();
        int num = rand.nextInt(3);
        if(num == 0){
            return "Active";
        }
        else if(num == 1){
            return "On Leave";
        }
        else{
            return "Terminated";
        }
    }

    public static String getRandomDepartment(){
        List<String> statusList = Arrays.asList("HR", "IT", "Sales", "Finance", "Marketing", "Customer Service", "PR");
        ArrayList<String> statusNames = new ArrayList<>(statusList);
        return statusNames.get(chooseRandomNumber(statusNames.size()));
    }

    public static String getRandomGender(){
        Random rand = new Random();
        int num = rand.nextInt(3);
        if(num == 0){
            return "Male";
        }
        else if(num == 1){
            return "Female";
        }
        else{
            return "Other";
        }
    }

    public static String getRandomEmail() {
        Random random = new Random();
        String username = getRandomString(8); // Adjust the length as needed
        String[] domains = {"gmail.com", "proton.net", "dummy.io"};
        String domain = domains[random.nextInt(domains.length)];
        return username + "@" + domain;
    }

    public static String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            builder.append(characters.charAt(index));
        }
        return builder.toString();
    }

    public static User generateSemiRandomUser(){
        String firstName = getRandomFirstName();
        String middleName = getRandomMiddleName();
        String lastName = getRandomLastName();

        int birthYear = 1960 + chooseRandomNumber(45);
        int birthMonth = 1 + chooseRandomNumber(12);
        //This should suffice
        int birthDay = 1 + chooseRandomNumber(25);
        int joinYear = 2010 + chooseRandomNumber(13);
        int joinMonth = 1 + chooseRandomNumber(12);
        //This should suffice
        int joinDay = 1 + chooseRandomNumber(25);
//        String thousands = String.valueOf(30 + chooseRandomNumber(70));
//        String salary = thousands + "000";
        int yearSalary = roundUpToNearestThousand(30000 + chooseRandomNumber(30000));
        int numberOfChildren = chooseRandomNumber(4);
        int numberOfCars = chooseRandomNumber(3);
        return new User(firstName, middleName, lastName, birthYear, birthMonth, birthDay, joinYear, joinMonth, joinDay,
                yearSalary, numberOfCars, numberOfChildren);
    }

    public static int chooseRandomNumber(int size){
        Random rand = new Random();
        return rand.nextInt(size);
    }

    public static int roundUpToNearestThousand(int number) {
        if (number % 1000 == 0) {
            return number;
        }
        int difference = 1000 - (number % 1000);
        return number + difference;
    }

    public static String createName(String firstName, String middleName, String lastName){
        if(middleName.length() > 0) {
            return firstName + " " + middleName + " " + lastName;
        }
        else{
            return firstName + " " + lastName;
        }
    }
}
