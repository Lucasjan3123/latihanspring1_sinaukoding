package com.example.sinaukoding.Service;

import com.example.sinaukoding.Entity.dto.PembayaranDTO;

import java.util.List;

public interface PembayaranService {
    PembayaranDTO save(PembayaranDTO param);

    List<PembayaranDTO> findAllData();

    PembayaranDTO update(PembayaranDTO param, Integer id_pembayaran);

    Boolean delete(Integer id_pembayaran);

    PembayaranDTO findById(Integer id_pembayaran);

}
