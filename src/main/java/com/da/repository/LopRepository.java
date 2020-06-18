package com.da.repository;

import com.da.model.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LopRepository extends JpaRepository<Lop, Integer>, JpaSpecificationExecutor<Lop> {
    @Query(
            nativeQuery = true,
            value = "select * from lop as lo where lo.tenlop =?1"
    )
    Lop findByTenlop(String tenLop);


    @Query(
            nativeQuery = true,
            value = "select * from lop as lo where lo.tenlop LIKE BINARY ?1"
    )
    Optional<Lop> findTenLopOptinal(String tenLop);

    @Query(
            nativeQuery = true,
            value = "select * from lop as lo where lo.ma_lop =?1"
    )
    Lop findByMaLop(String maLop);

    @Query(
            nativeQuery = true,
            value = "select * from lop as lo where lo.ma_lop=?1"
    )
    Optional<Lop> findBYmAlOP(String tenLop);
}
