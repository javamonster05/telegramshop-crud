package com.javamonster.spring.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @Column(name="Product_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="Product_Name")
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Supplier_ID")
    private Supplier supplier;

    @Column(name = "Product_Price")
    private int price;

    @Column(name = "Product_Description")
    private String description;

    @Column(name = "Product_ImageId")
    private String imageId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", supplier=" + supplier +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }
}
