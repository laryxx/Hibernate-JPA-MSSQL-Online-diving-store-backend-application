package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "ProductCategories")
public class ProductCategory {
    @Id
    long Id;

    @Column(name = "categoryName")
    public String name;

    public ProductCategory(){

    }

    public ProductCategory(String name){
        this.name = name;
        ArrayList<String> values = new ArrayList<>();
        values.add(name);
        this.Id = Main.CreateCRC32Id(values);
    }

    public void setId(long id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product Category Id: " + this.Id + "\n" +
                "Product Category Name: " + this.name;
    }
}
