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
    @Column
    private Date tanggal;
    @Column (columnDefinition = "VARCHAR(100)")
    private  String keterangan;

    @ManyToOne
    @JoinColumn (name = "id_barang")
    private Barang barang;

    @OneToMany(mappedBy = "transaksi")
    private List<Pembayaran> pembayaranList;

    @ManyToOne
    @JoinColumn(name = "id_pembeli")
    private  Pembeli pembeli;
}
