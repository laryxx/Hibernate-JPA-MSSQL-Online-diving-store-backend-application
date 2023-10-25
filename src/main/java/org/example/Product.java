package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    long Id;

    @Column(name = "productName")
    String name;

    @Column(name = "priceUSD")
    int price;

    @Column(name = "unitPriceUSD")
    int unitPrice;

    @Column(name = "importer")
    String importer;

    @Column(name = "manufacturer")
    String manufacturer;

    @Column(name = "color")
    String color;

    @ManyToOne
    @JoinColumn(name = "productSubcategory_Id")
    private ProductSubcategory productSubcategory;

    @OneToMany(mappedBy = "product")
    List<OrderLine> orderLines;

    public Product(){

    }

    public Product(String name, int price, String color, ProductSubcategory productSubcategory, int unitPrice,
                   String importer, String manufacturer){
        this.name = name;
        this.price = price;
        this.color = color;
        this.productSubcategory = productSubcategory;
        ArrayList<String> values = new ArrayList<>();
        values.add(name);
        values.add(String.valueOf(price));
        values.add(color);
        values.add(productSubcategory.getName());
        this.Id = Main.CreateCRC32Id(values);
        this.unitPrice = unitPrice;
        this.importer = importer;
        this.manufacturer = manufacturer;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductSubcategory(ProductSubcategory productSubcategory) {
        this.productSubcategory = productSubcategory;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return Id;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public ProductSubcategory getProductSubcategory() {
        return productSubcategory;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getImporter() {
        return importer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Product Id: " + this.Id + "\n" +
                "Product Name: " + this.name + "\n" +
                "Product Price (USD): " + this.price + "\n" +
                "Product Subcategory: " + this.productSubcategory.getName() + "\n" +
                "Product Category: " + this.productSubcategory.getProductCategory().getName() + "\n";
    }
}
