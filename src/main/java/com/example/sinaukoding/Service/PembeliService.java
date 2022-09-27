package com.example.sinaukoding.Service;
import com.example.sinaukoding.Entity.dto.PembeliDTO;
import java.util.List;

public interface PembeliService {
    PembeliDTO save(PembeliDTO param);

    List<PembeliDTO> findAllData();

    PembeliDTO update(PembeliDTO param, Integer id_pembeli);

    Boolean delete(Integer id_pembeli);

    PembeliDTO findById(Integer id_pembeli);
}
