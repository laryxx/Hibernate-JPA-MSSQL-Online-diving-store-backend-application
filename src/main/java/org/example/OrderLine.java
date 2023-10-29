package org.example;
import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "OrderLines")
public class OrderLine {
    @Id
    long Id;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_Id")
    Order order;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_Id")
    Product product;

    @Column(name = "unitPrice")
    int unitPrice;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "totalPrice")
    int totalPrice;

    @Column(name = "discountFreeTotalPrice")
    int discountFreeTotalPrice;

    @ManyToOne(targetEntity = ItemDiscount.class)
    @JoinColumn(name = "itemDiscount_Id")
    ItemDiscount itemDiscount;

    public OrderLine(){

    }

    public OrderLine(Order order, Product product, int unitPrice, int quantity, int totalPrice,
                     int discountFreeTotalPrice, ItemDiscount itemDiscount){
        ArrayList<String> values = new ArrayList<>();
        this.order = order;
        this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.discountFreeTotalPrice = discountFreeTotalPrice;
        this.itemDiscount = itemDiscount;
        //values.add(String.valueOf(order));
        values.add(String.valueOf(product));
        values.add(String.valueOf(unitPrice));
        values.add(String.valueOf(totalPrice));
        values.add(String.valueOf(discountFreeTotalPrice));
        values.add(String.valueOf(itemDiscount));
        this.Id = Main.CreateCRC32Id(values);
    }

    public void setId(long id) {
        Id = id;
    }

    public void setDiscountFreeTotalPrice(int discountFreeTotalPrice) {
        this.discountFreeTotalPrice = discountFreeTotalPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setItemDiscount(ItemDiscount itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return Id;
    }

    public int getDiscountFreeTotalPrice() {
        return discountFreeTotalPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ItemDiscount getItemDiscount() {
        return itemDiscount;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return  "Order Line Id: " + getId() + "\n" +
                "Product Key: " + getProduct().toString() + "\n" +
                "Unit Price: " + getUnitPrice() + "\n" +
                "Quantity: " + getQuantity() + "\n" +
                "Total Price: " + getTotalPrice() + "\n" +
                "Discount Free Total Price: " + getDiscountFreeTotalPrice() + "\n";
    }
}
