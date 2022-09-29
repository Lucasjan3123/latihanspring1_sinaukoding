package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.Mapping.PembayaranMapping;
import com.example.sinaukoding.Entity.Pembayaran;
import com.example.sinaukoding.Entity.dto.PembayaranDTO;
import com.example.sinaukoding.Repository.PembayaranRepository;
import com.example.sinaukoding.Repository.TransaksiRepository;
import com.example.sinaukoding.Service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembayaranServiceImpl implements PembayaranService {
    @Autowired
    private PembayaranRepository repository;
    @Autowired
    private TransaksiRepository transaksiRepository;

    @Override
    public PembayaranDTO save(PembayaranDTO param) {
        Pembayaran data = repository.save(PembayaranMapping.instance.toEntity(param));
        return PembayaranMapping.instance.toDto(data);
    }

    @Override
    public List<PembayaranDTO> findAllData() {
        return PembayaranMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public PembayaranDTO update(PembayaranDTO param, Integer id_pembayaran) {
        Pembayaran data = repository.findById(id_pembayaran).orElse(null);

        if (data != null) {
            data.setTgl_bayar(param.getTgl_bayar() == null ? data.getTgl_bayar() : param.getTgl_bayar());
            data.setTotal_bayar(param.getTotal_bayar() != null ? param.getTotal_bayar() : data.getTotal_bayar());
            data.setId_transaksi(param.getId_transaksi() != null ? param.getId_transaksi() : data.getId_transaksi());


            return PembayaranMapping.instance.toDto(repository.save(data));

        }

        return PembayaranMapping.instance.toDto(data);

    }

    @Override
    public Boolean delete(Integer id_pembayaran) {
        return null;
    }

    @Override
    public PembayaranDTO findById(Integer id_pembayaran) {
        return null;
    }
}
