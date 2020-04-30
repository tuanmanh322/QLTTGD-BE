package com.da.repository;

import com.da.model.LoaiThe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiTheRepository extends JpaRepository<LoaiThe,Integer> {
}
