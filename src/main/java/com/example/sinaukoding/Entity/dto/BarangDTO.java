package com.example.sinaukoding.Entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarangDTO {
    private Integer id_barang;
    private String nama_barang;
    private Integer harga;
    private Integer stok;
    private SupplierDTO supplier;



}
