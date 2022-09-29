package com.example.sinaukoding.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pembeli")
@Getter
@Setter
@NoArgsConstructor
public class Pembeli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Integer id_pembeli;

    @Column(columnDefinition = "VARCHAR(30)")
    private String nama_pembeli;
    @Column(columnDefinition = "CHAR(1)")
    private Character jk;
    @Column(columnDefinition = "CHAR(14)")
    private Integer no_telp;
    @Column(columnDefinition = "VARCHAR(30)")
    private String alamat;

    @OneToMany (mappedBy = "pembeli")
    private List<Transaksi> transaksiList;

}
