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
    @Column(columnDefinition = "INT(11)")
    private Integer id_supplier;
    @Column(columnDefinition = "VARCHAR(30)")
    private String nama_supplier;
    @Column(columnDefinition = "CHAR(13)")
    private Integer no_telp;
    @Column(columnDefinition = "VARCHAR(100)")
    private String alamat;
   @OneToMany(mappedBy = "supplier")
    private List<Barang>barangList;
}
