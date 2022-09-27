package com.example.sinaukoding.Repository;

import com.example.sinaukoding.Entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepository extends JpaRepository<Barang, Integer> {
}
