package com.da.repository;

import com.da.model.ChiTietHocPhi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietHocPhiRepository extends JpaRepository<ChiTietHocPhi,Integer> {
}
