package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.pembeli;
import com.example.sinaukoding.Repository.PembeliRepository;
import com.example.sinaukoding.Service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class PembeliServiceImpl implements PembeliService {
    @Autowired
    private PembeliRepository repository;


    @Override
    public pembeli save(pembeli param) {
        return repository.save(param);

    }

    @Override
    public List<pembeli> findAllData() {
        return repository.findAll();

    }

    @Override
    public pembeli update(pembeli param, Integer id_pembeli) {
        pembeli data = repository.findById(id_pembeli).orElse(null);

        if (data != null) {
            data.setNama_pembeli(param.getNama_pembeli() == null ? data.getNama_pembeli() : param.getNama_pembeli());
            data.setJk(param.getJk() != null ? param.getJk() : data.getJk());
            data.setNo_telp(param.getNo_telp() != null ? param.getNo_telp() : data.getNo_telp());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());


            return repository.save(data);
        }

        return data;
    }

    @Override
    public Boolean delete(Integer id_pembeli) {
        pembeli data = repository.findById(id_pembeli).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public pembeli findById(Integer id_pembeli) {
        return repository.findById(id_pembeli).orElse(null);

    }
}
