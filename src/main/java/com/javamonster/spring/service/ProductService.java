package com.javamonster.spring.service;

import com.javamonster.spring.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product p);
    void updateProduct(Product p);
    List<Product> listProduct();
    Product getProdictById(int id);
    void removeProduct(int id);
}
