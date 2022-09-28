package com.example.Sinaukoding.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import  lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

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
    @Column
    private Integer id_supplier;

}
