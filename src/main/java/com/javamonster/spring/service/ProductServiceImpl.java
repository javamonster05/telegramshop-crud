package com.javamonster.spring.service;

import com.javamonster.spring.dao.ProductDAO;
import com.javamonster.spring.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDAO productDAO;

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    @Override
    @Transactional
    public void addProduct(Product p) {
        productDAO.addProduct(p);
    }

    @Override
    @Transactional
    public void updateProduct(Product p) {
        productDAO.updateProduct(p);
    }

    @Override
    @Transactional
    public List<Product> listProduct() {
        return productDAO.listProduct();
    }

    @Override
    @Transactional
    public Product getProdictById(int id) {
        return productDAO.getProdictById(id);
    }

    @Override
    @Transactional
    public void removeProduct(int id) {
        productDAO.removeProduct(id);
    }
}
