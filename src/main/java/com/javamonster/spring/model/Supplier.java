package com.javamonster.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier {
    @Id
    @Column(name="Supplier_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "supplier")
    private List<Product> products = new ArrayList<Product>();

    @Column(name = "Supplier_Name")
    private String name;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
