package com.javamonster.spring.dao;

import com.javamonster.spring.model.Product;

import java.util.List;

public interface ProductDAO {
    void addProduct(Product p);
    void updateProduct(Product p);
    List<Product> listProduct();
    Product getProdictById(int id);
    void removeProduct(int id);
}
