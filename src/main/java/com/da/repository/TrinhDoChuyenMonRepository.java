package com.da.repository;

import com.da.model.TrinhDoChuyenMon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrinhDoChuyenMonRepository extends JpaRepository<TrinhDoChuyenMon,Integer> {
}
