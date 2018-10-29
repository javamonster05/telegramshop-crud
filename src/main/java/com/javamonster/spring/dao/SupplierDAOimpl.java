package com.javamonster.spring.dao;

import com.javamonster.spring.model.Supplier;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SupplierDAOimpl implements SupplierDAO {

    private static final Logger logger = LoggerFactory.getLogger(SupplierDAOimpl.class);

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSupplier(Supplier s) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(s);
        logger.info("Supplier saved successfully, Supplier details: "+s);
    }

    @Override
    public void updateSupplier(Supplier s) {
        Session session = sessionFactory.getCurrentSession();
        session.update(s);
        logger.info("Supplier updated successfully, Supplier details: "+s);
    }

    @Override
    public List<Supplier> listSuppliers() {
        Session session = sessionFactory.getCurrentSession();
        List<Supplier> supplierList = session.createQuery("from Supplier").list();
        for (Supplier s :supplierList) {
            logger.info("Supplier list:: " + s);
        }
        return supplierList;
    }

    @Override
    public Supplier getSupplierById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Supplier s = (Supplier) session.load(Supplier.class, new Integer(id));
        logger.info("Supplier loaded succesfully, Supplier details" + s);
        return s;
    }

    @Override
    public void removeSupplier(int id) {
        Session session = sessionFactory.getCurrentSession();
        Supplier s = (Supplier) session.load(Supplier.class, new Integer(id) );
        if(null != s){
            session.delete(s);
        }
        logger.info("Supplier deleted successfully, Supplier details" + s);
    }
}
