package com.example.sinaukoding.Service;
import com.example.sinaukoding.Entity.Barang;

import java.util.List;

public interface BarangService {
    Barang save(Barang param);

    List<Barang> findAllData();

    Barang update(Barang param, Integer id_barang);

    Boolean delete(Integer id_barang);

    Barang findById(Integer id_barang);
}
