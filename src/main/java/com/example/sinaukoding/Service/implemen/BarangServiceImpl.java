package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.Barang;
import com.example.sinaukoding.Repository.BarangRepository;
import com.example.sinaukoding.Service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class BarangServiceImpl implements BarangService {
    @Autowired
    private BarangRepository repository;

    @Override
    public Barang save(Barang param) {
        return repository.save(param);
    }

    @Override
    public List<Barang> findAllData() {
        return repository.findAll();
    }

    @Override
    public Barang update(Barang param, Integer id_barang) {
        Barang data = repository.findById(id_barang).orElse(null);

        if (data != null) {
            data.setNama_barang(param.getNama_barang() == null ? data.getNama_barang() : param.getNama_barang());
            data.setHarga(param.getHarga() != null ? param.getHarga() : data.getHarga());
            data.setStok(param.getStok() != null ? param.getStok() : data.getStok());
            data.setId_supplier(param.getId_supplier() != null ? param.getId_supplier() : data.getId_supplier());


            return repository.save(data);
        }

        return data;
    }

    @Override
    public Boolean delete(Integer id_barang) {
        Barang data = repository.findById(id_barang).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public Barang findById(Integer id_barang) {
        return repository.findById(id_barang).orElse(null);
    }
}
