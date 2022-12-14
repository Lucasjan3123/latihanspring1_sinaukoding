package com.example.sinaukoding.Service;

import com.example.sinaukoding.Entity.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO save(SupplierDTO param);

    List<SupplierDTO> findAllData();

    SupplierDTO update(SupplierDTO param, Integer id_supplier);

    Boolean delete(Integer id_supplier);

    SupplierDTO findById(Integer id_supplier);
}
