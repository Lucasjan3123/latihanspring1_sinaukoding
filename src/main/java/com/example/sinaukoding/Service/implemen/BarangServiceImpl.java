package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.Barang;
import com.example.sinaukoding.Entity.Mapping.BarangMapping;
import com.example.sinaukoding.Entity.dto.BarangDTO;
import com.example.sinaukoding.Repository.BarangRepository;
import com.example.sinaukoding.Service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BarangServiceImpl implements BarangService {
    @Autowired
    private BarangRepository repository;

    @Override
    public BarangDTO save(BarangDTO param) {
        Barang data = repository.save(BarangMapping.instance.toEntity(param));
        return BarangMapping.instance.toDto(data);
    }

    @Override
    public List<BarangDTO> findAllData() {
        return BarangMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public BarangDTO update(BarangDTO param, Integer id_barang) {
        Barang data = repository.findById(id_barang).orElse(null);

        if (data != null) {
            data.setNama_barang(param.getNama_barang() == null ? data.getNama_barang() : param.getNama_barang());
            data.setHarga(param.getHarga() != null ? param.getHarga() : data.getHarga());
            data.setStok(param.getStok() != null ? param.getStok() : data.getStok());
            data.setId_supplier(param.getId_supplier() != null ? param.getId_supplier() : data.getId_supplier());


            return BarangMapping.instance.toDto(repository.save(data));
        }

        return BarangMapping.instance.toDto(data);
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
    public BarangDTO findById(Integer id_barang) {
        return BarangMapping.instance.toDto(repository.findById(id_barang).orElse(null));
    }
}
