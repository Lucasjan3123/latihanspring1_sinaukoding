package com.example.sinaukoding.Service;
import com.example.sinaukoding.Entity.pembeli;
import java.util.List;

public interface PembeliService {
    pembeli save(pembeli param);

    List<pembeli> findAllData();

    pembeli update(pembeli param, Integer id_pembeli);

    Boolean delete(Integer id_pembeli);

    pembeli findById(Integer id_pembeli);
}
