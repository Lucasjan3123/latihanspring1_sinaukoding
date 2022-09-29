package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.Barang;
import com.example.sinaukoding.Entity.Mapping.BarangMapping;
import com.example.sinaukoding.Entity.Mapping.SupplierMapping;
import com.example.sinaukoding.Entity.Supplier;
import com.example.sinaukoding.Entity.dto.BarangDTO;
import com.example.sinaukoding.Repository.BarangRepository;
import com.example.sinaukoding.Repository.SupplierRepository;
import com.example.sinaukoding.Repository.TransaksiRepository;
import com.example.sinaukoding.Service.BarangService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BarangServiceImpl implements BarangService {
    @Autowired
    private BarangRepository repository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private TransaksiRepository transaksiRepository;
    @Transactional
    @Override
    public BarangDTO save(BarangDTO param) {
        Supplier supplier = SupplierMapping.instance.toEntity(param.getSupplier());

        Barang data = BarangMapping.instance.toEntity(param);

        if (param.getSupplier() != null) {
            supplier = supplierRepository.save(supplier);

            data.getSupplier().setId_supplier(supplier.getId_supplier());
        }

        data = repository.save(data);

        return BarangMapping.instance.toDto(data);
    }
    @Transactional
    @Override
    public List<BarangDTO> findAllData() {
        return BarangMapping.instance.toListDto(repository.findAll());
    }
    @Transactional
    @Override
    public BarangDTO update(BarangDTO param, Integer id_barang) {
        Barang data = repository.findById(id_barang).orElse(null);

        if (data != null) {
            data.setNama_barang(param.getNama_barang() == null ? data.getNama_barang() : param.getNama_barang());
            data.setHarga(param.getHarga() != null ? param.getHarga() : data.getHarga());
            data.setStok(param.getStok() != null ? param.getStok() : data.getStok());


            return BarangMapping.instance.toDto(repository.save(data));
        }

        return BarangMapping.instance.toDto(data);
    }
    @Transactional
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
