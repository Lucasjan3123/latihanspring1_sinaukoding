package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.Supplier;
import com.example.sinaukoding.Repository.SupplierRepository;
import com.example.sinaukoding.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository repository;

    @Override
    public Supplier save(Supplier param) {
        return repository.save(param);

    }

    @Override
    public List<Supplier> findAllData() {
        return repository.findAll();

    }

    @Override
    public Supplier update(Supplier param, Integer id_supplier) {
        Supplier data = repository.findById(id_supplier).orElse(null);

        if (data != null) {
            data.setNama_supplier(param.getNama_supplier() == null ? data.getNama_supplier() : param.getNama_supplier());
            data.setNo_telp(param.getNo_telp() != null ? param.getNo_telp() : data.getNo_telp());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());


            return repository.save(data);
        }

        return data;
    }

    @Override
    public Boolean delete(Integer id_supplier) {
        Supplier data = repository.findById(id_supplier).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public Supplier findById(Integer id_supplier) {
        return repository.findById(id_supplier).orElse(null);

    }
}
