package com.example.sinaukoding.Service;

import com.example.sinaukoding.Entity.dto.TransaksiDTO;

import java.util.List;

public interface TransaksiService {
    TransaksiDTO save(TransaksiDTO param);

    List<TransaksiDTO> findAllData();

    TransaksiDTO update(TransaksiDTO param, Integer id_transaksi);

    Boolean delete(Integer id_transaksi);

    TransaksiDTO findById(Integer id_transaksi);
}
