package com.example.Sinaukoding.Service.implemen;

import com.example.Sinaukoding.Entity.Mapping.PembeliMapping;
import com.example.Sinaukoding.Entity.Pembeli;
import com.example.Sinaukoding.Entity.dto.PembeliDTO;
import com.example.Sinaukoding.Repository.PembeliRepository;
import com.example.Sinaukoding.Service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PembeliServiceImpl implements PembeliService {
    @Autowired
    private PembeliRepository repository;


    @Override
    public PembeliDTO save(PembeliDTO param) {
        Pembeli data = repository.save(PembeliMapping.instance.toEntity(param));
        return PembeliMapping.instance.toDto(data);


    }

    @Override
    public List<PembeliDTO> findAllData() {
        return PembeliMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public PembeliDTO update(PembeliDTO param, Integer id_pembeli) {
        Pembeli data = repository.findById(id_pembeli).orElse(null);

        if (data != null) {
            data.setNama_pembeli(param.getNama_pembeli() == null ? data.getNama_pembeli() : param.getNama_pembeli());
            data.setJk(param.getJk() != null ? param.getJk() : data.getJk());
            data.setNo_telp(param.getNo_telp() != null ? param.getNo_telp() : data.getNo_telp());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());


            return PembeliMapping.instance.toDto(repository.save(data));
        }

        return PembeliMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Integer id_pembeli) {
        Pembeli data = repository.findById(id_pembeli).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PembeliDTO findById(Integer id_pembeli) {
        return PembeliMapping.instance.toDto (repository.findById(id_pembeli).orElse(null));

    }
}
