package com.example.sinaukoding.Entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
@Getter
@Setter
public class PembeliDTO {
    private Integer id_pembeli;
    private VarcharTypeDescriptor nama_pembeli;
    private Character jk;
    private Character no_telp;
    private String alamat;
}
