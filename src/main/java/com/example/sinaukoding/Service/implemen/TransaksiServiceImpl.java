package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.*;
import com.example.sinaukoding.Entity.Mapping.*;
import com.example.sinaukoding.Entity.dto.TransaksiDTO;
import com.example.sinaukoding.Repository.BarangRepository;
import com.example.sinaukoding.Repository.PembayaranRepository;
import com.example.sinaukoding.Repository.PembeliRepository;
import com.example.sinaukoding.Repository.TransaksiRepository;
import com.example.sinaukoding.Service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransaksiServiceImpl implements TransaksiService {
    @Autowired
    private TransaksiRepository repository;
    @Autowired
    private BarangRepository barangRepository;
    @Autowired
    private PembayaranRepository pembayaranRepository;
    @Autowired
    private PembeliRepository pembeliRepository;
    @Override
    public TransaksiDTO save(TransaksiDTO param) {
        Barang barang = BarangMapping.instance.toEntity(param.getBarang());

        Transaksi data = TransaksiMapping.instance.toEntity(param);

        if (param.getBarang() != null) {
            barang = barangRepository.save(barang);

            data.getBarang().setId_barang(barang.getId_barang());
        }
        Pembayaran pembayaran = PembayaranMapping.instance.toEntity(param.getPembayaran());
        if (param.getPembayaran() != null) {
            pembayaran = pembayaranRepository.save(pembayaran);

            data.getPembayaran().setId_pembayaran(pembayaran.getId_pembayaran());
        }
        Pembeli pembeli = PembeliMapping.instance.toEntity(param.getPembeli());
        if (param.getPembeli() != null) {
            pembeli = pembeliRepository.save(pembeli);

            data.getPembeli().setId_pembeli(pembeli.getId_pembeli());
        }

        data = repository.save(data);

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
