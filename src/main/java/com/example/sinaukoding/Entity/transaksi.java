    package com.example.sinaukoding.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="transaksi" )
@Getter
@Setter
@NoArgsConstructor
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Integer id_transaksi;

    @Column(columnDefinition = "INT(11)")
    private  Integer id_barang;
    @Column(columnDefinition = "INT(11)")
    private Integer id_pembeli;
    @Column
    private Date tanggal;
    @Column (columnDefinition = "VARCHAR(100)")
    private  String keterangan;
    @OneToMany(mappedBy = "transaksi")
    private List<Barang> barangList;
    @OneToMany(mappedBy = "transaksi")
    private List<Pembayaran> pembayaranList;
    @OneToMany(mappedBy = "transaksi")
    private List<Pembeli> pembeliList;
}
