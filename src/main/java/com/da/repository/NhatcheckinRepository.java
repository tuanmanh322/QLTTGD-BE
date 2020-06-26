package com.da.repository;

import com.da.model.Nhatcheckin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhatcheckinRepository extends JpaRepository<Nhatcheckin, Integer>, JpaSpecificationExecutor<Nhatcheckin> {

    @Query(nativeQuery = true,value = "SELECT * FROM nhatcheckin as ncc where ncc.ma_the=?1")
    List<Nhatcheckin> findByMaThe(Integer idThe);
}
