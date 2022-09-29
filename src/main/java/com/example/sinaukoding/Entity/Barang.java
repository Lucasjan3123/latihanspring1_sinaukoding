package com.example.sinaukoding.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import  lombok.Setter;

import  javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "barang")
@Getter
@Setter
@NoArgsConstructor
public class Barang {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Integer id_barang;
    @Column(columnDefinition = "VARCHAR(20)")
    private String nama_barang;
    @Column(columnDefinition = "INT(11)")
    private Integer harga;
    @Column(columnDefinition = "INT(11)")
    private Integer stok;
    @ManyToOne
    @JoinColumn (name = "id_supplier")
    private Supplier supplier;
    @OneToMany(mappedBy = "barang")
    private List<Transaksi> transaksiList;

}
