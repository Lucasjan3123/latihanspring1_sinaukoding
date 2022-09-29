package com.example.sinaukoding.Repository;

import com.example.sinaukoding.Entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {
}
