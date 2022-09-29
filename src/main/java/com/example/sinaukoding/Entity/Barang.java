package com.example.sinaukoding.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import  lombok.Setter;

import  javax.persistence.*;

@Entity
@Table (name = "barang")
@Getter
@Setter
@NoArgsConstructor
public class Barang {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_barang;
    @Column
    private String nama_barang;
    @Column
    private Integer harga;
    @Column
    private Integer stok;
    @ManyToOne
    @JoinColumn (name = "id_supplier")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn (name = "id_transaksi")
    private Transaksi transaksi;
}
