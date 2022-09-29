package com.example.sinaukoding.Entity.dto;

import com.example.sinaukoding.Entity.Pembeli;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransaksiDTO {
    private Integer id_transaksi;
    private Date tanggal;
    private  String keterangan;
    private BarangDTO barang;
    private PembayaranDTO pembayaran;
    private PembeliDTO pembeli;



}
