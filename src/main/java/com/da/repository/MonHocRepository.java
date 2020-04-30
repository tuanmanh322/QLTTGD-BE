package com.da.repository;

import com.da.model.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc,Integer> {
}
