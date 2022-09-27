package com.example.sinaukoding.Service;
import com.example.sinaukoding.Entity.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier save(Supplier param);

    List<Supplier> findAllData();

    Supplier update(Supplier param, Integer id_supplier);

    Boolean delete(Integer id_supplier);

    Supplier findById(Integer id_supplier);
}
