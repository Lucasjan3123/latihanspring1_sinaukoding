package com.example.sinaukoding.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
@Getter
@Setter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_supplier;
    @Column
    private VarcharTypeDescriptor nama_supplier;
    @Column
    private Character no_telp;
    @Column
    private VarcharTypeDescriptor alamat;

}
