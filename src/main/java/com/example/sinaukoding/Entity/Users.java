package com.example.sinaukoding.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String username ;
    @Column
    private  String password;
    @Column
    private  String profilNama;

}
