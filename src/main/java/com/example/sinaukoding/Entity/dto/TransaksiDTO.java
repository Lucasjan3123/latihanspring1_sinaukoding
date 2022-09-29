package com.example.sinaukoding.Entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransaksiDTO {
    private Integer id_transaksi;
    private  Integer id_barang;
    private Integer id_pembeli;
    private Date tanggal;
    private  String keterangan;
}
