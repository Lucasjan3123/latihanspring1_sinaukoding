package com.example.sinaukoding.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_supplier;
    @Column
    private String nama_supplier;
    @Column
    private Integer no_telp;
    @Column
    private String alamat;
   @OneToMany(mappedBy = "supplier")
    private List<Barang>barangList;
}
