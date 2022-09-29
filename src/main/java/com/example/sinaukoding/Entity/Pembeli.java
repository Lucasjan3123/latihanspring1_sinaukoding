package com.example.sinaukoding.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "pembeli")
@Getter
@Setter
@NoArgsConstructor
public class Pembeli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pembeli;

    @Column
    private String nama_pembeli;
    @Column
    private Character jk;
    @Column
    private Integer no_telp;
    @Column
    private String alamat;
    @ManyToOne
    @JoinColumn (name = "id_transaksi")
    private Transaksi transaksi;

}
