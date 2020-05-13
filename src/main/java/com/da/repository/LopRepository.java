package com.da.repository;

import com.da.model.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LopRepository extends JpaRepository<Lop, Integer>, JpaSpecificationExecutor<Lop> {
    @Query(
            nativeQuery = true,
            value = "select lo from lop as lo where lo.tenlop =?1"
    )
    Lop findByTenlop(String tenLop);
}
