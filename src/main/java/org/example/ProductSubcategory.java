package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "ProductSubcategories")
public class ProductSubcategory {
    @Id
    long Id;

    @Column(name = "subcategoryName")
    public String name;

    @ManyToOne
    @JoinColumn(name = "productCategory_Id")
    private ProductCategory productCategory;

    public ProductSubcategory(){

    }

    public ProductSubcategory(String name, ProductCategory productCategory){
        this.name = name;
        ArrayList<String> values = new ArrayList<>();
        values.add(name);
        this.Id = Main.CreateCRC32Id(values);
        this.productCategory = productCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    @Override
    public String toString() {
        return "Product Subcategory Id: " + this.Id + "\n" +
                "Product Subcategory Name: " + this.name + "\n" +
                "Product Category Name: " + this.productCategory.getName();
    }
}
