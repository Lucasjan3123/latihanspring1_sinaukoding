package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.Mapping.SupplierMapping;
import com.example.sinaukoding.Entity.Supplier;
import com.example.sinaukoding.Entity.dto.SupplierDTO;
import com.example.sinaukoding.Repository.SupplierRepository;
import com.example.sinaukoding.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository repository;

    @Override
    public SupplierDTO save(SupplierDTO param) {
        Supplier data = repository.save(SupplierMapping.instance.toEntity(param));
        return SupplierMapping.instance.toDto(data);

    }
    @Transactional
    @Override
    public List<SupplierDTO> findAllData() {
        return SupplierMapping.instance.toListDto(repository.findAll());


    }
    @Transactional
    @Override
    public SupplierDTO update(SupplierDTO param, Integer id_supplier) {
        Supplier data = repository.findById(id_supplier).orElse(null);

        if (data != null) {
            data.setNama_supplier(param.getNama_supplier() == null ? data.getNama_supplier() : param.getNama_supplier());
            data.setNo_telp(param.getNo_telp() != null ? param.getNo_telp() : data.getNo_telp());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());


            return SupplierMapping.instance.toDto(repository.save(data));

        }

        return SupplierMapping.instance.toDto(data);

    }
    @Transactional
    @Override
    public Boolean delete(Integer id_supplier) {
        Supplier data = repository.findById(id_supplier).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }
    @Transactional
    @Override
    public SupplierDTO findById(Integer id_supplier) {
        return SupplierMapping.instance.toDto (repository.findById(id_supplier).orElse(null));

    }
}
