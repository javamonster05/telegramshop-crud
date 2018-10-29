package com.javamonster.spring.dao;

import com.javamonster.spring.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOimpl implements ProductDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOimpl.class);

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProduct(Product p) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Product saved. Product info: "+p);
    }

    @Override
    public void updateProduct(Product p) {
        Session session = sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Product updated. Product info: "+p);
    }

    @Override
    public List<Product> listProduct() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> productList = session.createQuery("from Product").list();
        logger.info("Product list");
        for(Product p : productList){
            logger.info(""+p);
        }
        return productList;
    }

    @Override
    public Product getProdictById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product p = (Product) session.load(Product.class, new Integer(id));
        logger.info("Produt obtained. Product info: " + p);
        return p;
    }

    @Override
    public void removeProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product p = (Product) session.load(Product.class, new Integer(id));
        session.delete(p);
        logger.info("Produt deleted. Product info: " + p);
    }
}
