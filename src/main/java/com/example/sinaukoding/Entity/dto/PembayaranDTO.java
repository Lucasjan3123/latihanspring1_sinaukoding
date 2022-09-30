package com.example.sinaukoding.Entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PembayaranDTO {
    private Integer id_pembayaran;
    private  Date tgl_bayar;
    private Integer total_bayar;
    private TransaksiDTO transaksi;


}
