package com.javamonster.spring.service;

import com.javamonster.spring.model.Supplier;

import java.util.List;

public interface SupplierService {
    void addSupplier(Supplier s);
    void updateSupplier(Supplier s);
    List<Supplier> listSuppliers();
    Supplier getSupplierById(int id);
    void removeSupplier(int id);
}
