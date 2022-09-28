package com.example.Sinaukoding.Entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
@Getter
@Setter
public class SupplierDTO {
    private Integer id_supplier;
    private String nama_supplier;
    private Integer no_telp;
    private String alamat;
}
