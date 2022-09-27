package com.example.sinaukoding.Entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

@Getter
@Setter
public class BarangDTO {
    private Integer id_barang;
    private VarcharTypeDescriptor nama_barang;
    private Integer harga;
    private Integer stok;
    private Integer id_supplier;



}
