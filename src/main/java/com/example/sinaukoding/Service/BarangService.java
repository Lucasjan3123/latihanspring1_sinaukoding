package com.example.sinaukoding.Service;

import com.example.sinaukoding.Entity.dto.BarangDTO;

import java.util.List;

public interface BarangService {
    BarangDTO save(BarangDTO param);

    List<BarangDTO> findAllData();

    BarangDTO update(BarangDTO param, Integer id_barang);

    Boolean delete(Integer id_barang);

    BarangDTO findById(Integer id_barang);
}
