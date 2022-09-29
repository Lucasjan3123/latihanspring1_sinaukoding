package com.example.sinaukoding.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pembayaran")
@Getter
@Setter
@NoArgsConstructor

public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Integer id_pembayaran;
    @Column
    private  Date tgl_bayar;
    @Column(columnDefinition = "INT(11)")
    private Integer total_bayar;
    @Column (columnDefinition = "INT(11)")
    private  Integer id_transaksi;
    @ManyToOne
    @JoinColumn (name = "id_transaksi")
    private Transaksi transaksi;
}
