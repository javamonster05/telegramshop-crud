package com.javamonster.spring.model;

import javax.persistence.*;

@Entity
public class Supplier {
    @Id
    @Column(name="Supplier_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

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

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
