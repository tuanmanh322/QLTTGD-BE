package com.da.repository;

import com.da.model.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LopRepository extends JpaRepository<Lop,Integer> {
}
