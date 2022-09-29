package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.Mapping.TransaksiMapping;
import com.example.sinaukoding.Entity.Transaksi;
import com.example.sinaukoding.Entity.dto.TransaksiDTO;
import com.example.sinaukoding.Repository.TransaksiRepository;
import com.example.sinaukoding.Service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransaksiServiceImpl implements TransaksiService {
    @Autowired
    private TransaksiRepository repository;

    @Override
    public TransaksiDTO save(TransaksiDTO param) {
        Transaksi data = repository.save(TransaksiMapping.instance.toEntity(param));
        return TransaksiMapping.instance.toDto(data);

    }

    @Override
    public List<TransaksiDTO> findAllData() {
        return TransaksiMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public TransaksiDTO update(TransaksiDTO param, Integer id_transaksi) {
        Transaksi data = repository.findById(id_transaksi).orElse(null);

        if (data != null) {
            data.setId_barang(param.getId_barang() == null ? data.getId_barang() : param.getId_barang());
            data.setId_pembeli(param.getId_pembeli() != null ? param.getId_pembeli() : data.getId_pembeli());
            data.setTanggal(param.getTanggal() != null ? param.getTanggal() : data.getTanggal());
            data.setKeterangan(param.getKeterangan() != null ? param.getKeterangan() : data.getKeterangan());


            return TransaksiMapping.instance.toDto(repository.save(data));

        }

        return TransaksiMapping.instance.toDto(data);

    }

    @Override
    public Boolean delete(Integer id_transaksi) {
        Transaksi data = repository.findById(id_transaksi).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;

    }

    @Override
    public TransaksiDTO findById(Integer id_transaksi) {
        return TransaksiMapping.instance.toDto (repository.findById(id_transaksi).orElse(null));

    }
}
