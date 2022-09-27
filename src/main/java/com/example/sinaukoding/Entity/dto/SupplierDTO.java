package com.example.sinaukoding.Entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
@Getter
@Setter
public class SupplierDTO {
    private Integer id_supplier;
    private VarcharTypeDescriptor nama_supplier;
    private Character no_telp;
    private VarcharTypeDescriptor alamat;
}
