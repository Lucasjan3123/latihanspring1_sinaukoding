package com.example.Sinaukoding.Entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
@Getter
@Setter
public class PembeliDTO {
    private Integer id_pembeli;
    private String nama_pembeli;
    private Character jk;
    private Character no_telp;
    private String alamat;
}
