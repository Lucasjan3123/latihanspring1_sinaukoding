package com.example.sinaukoding.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.*;

@Entity
@Table(name = "pembeli")
@Getter
@Setter
public class pembeli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pembeli;

    @Column
    private VarcharTypeDescriptor nama_pembeli;
    @Column
    private Character jk;
    @Column
    private Character no_telp;
    @Column
    private String alamat;

}
