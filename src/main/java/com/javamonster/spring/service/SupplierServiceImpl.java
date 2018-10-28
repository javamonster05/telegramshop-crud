package com.javamonster.spring.service;

import com.javamonster.spring.dao.SupplierDAO;
import com.javamonster.spring.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierDAO supplierDAO;

    public void setSupplierDAO(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
    }

    @Override
    @Transactional
    public void addSupplier(Supplier s) {
        supplierDAO.addSupplier(s);
    }

    @Override
    @Transactional
    public void updateSupplier(Supplier s) {
        supplierDAO.updateSupplier(s);
    }

    @Override
    @Transactional
    public List<Supplier> listSuppliers() {
        return supplierDAO.listSuppliers();
    }

    @Override
    @Transactional
    public Supplier getSupplierById(int id) {
        return supplierDAO.getSupplierById(id);
    }

    @Override
    @Transactional
    public void removeSupplier(int id) {
        supplierDAO.removeSupplier(id);
    }
}
