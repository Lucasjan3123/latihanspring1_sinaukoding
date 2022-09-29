package com.example.sinaukoding.Service.implemen;

import com.example.sinaukoding.Entity.Barang;
import com.example.sinaukoding.Entity.Mapping.BarangMapping;
import com.example.sinaukoding.Entity.Mapping.PembayaranMapping;
import com.example.sinaukoding.Entity.Mapping.TransaksiMapping;
import com.example.sinaukoding.Entity.Pembayaran;
import com.example.sinaukoding.Entity.Transaksi;
import com.example.sinaukoding.Entity.dto.PembayaranDTO;
import com.example.sinaukoding.Repository.PembayaranRepository;
import com.example.sinaukoding.Repository.TransaksiRepository;
import com.example.sinaukoding.Service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PembayaranServiceImpl implements PembayaranService {
    @Autowired
    private PembayaranRepository repository;
    @Autowired
    private TransaksiRepository transaksiRepository;
    @Transactional
    @Override
    public PembayaranDTO save(PembayaranDTO param) {
        Transaksi transaksi = TransaksiMapping.instance.toEntity(param.getTransaksi());

        Pembayaran data = PembayaranMapping.instance.toEntity(param);

        if (param.getTransaksi() != null) {
            transaksi = transaksiRepository.save(transaksi);

            data.getTransaksi().setId_transaksi(transaksi.getId_transaksi());
        }
        data = repository.save(data);

        return PembayaranMapping.instance.toDto(data);
    }
    @Transactional
    @Override
    public List<PembayaranDTO> findAllData() {
        return PembayaranMapping.instance.toListDto(repository.findAll());

    }
    @Transactional
    @Override
    public PembayaranDTO update(PembayaranDTO param, Integer id_pembayaran) {
        Pembayaran data = repository.findById(id_pembayaran).orElse(null);

        if (data != null) {
            data.setTgl_bayar(param.getTgl_bayar() == null ? data.getTgl_bayar() : param.getTgl_bayar());
            data.setTotal_bayar(param.getTotal_bayar() != null ? param.getTotal_bayar() : data.getTotal_bayar());


            return PembayaranMapping.instance.toDto(repository.save(data));

        }

        return PembayaranMapping.instance.toDto(data);

    }
    @Transactional
    @Override
    public Boolean delete(Integer id_pembayaran) {
        return null;
    }
    @Transactional
    @Override
    public PembayaranDTO findById(Integer id_pembayaran) {
        return null;
    }
}
