package com.da.repository;

import com.da.model.Monhoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonhocRepository extends JpaRepository<Monhoc, Integer>, JpaSpecificationExecutor<Monhoc> {
    @Query(nativeQuery = true,value = " select * from monhoc as mh where mh.tenmonhoc like ?1")
    Optional<Monhoc> findByTenmonhoc(String tenMonHoc);

    @Query(nativeQuery = true, value = "SELECT * from monhoc as mh where mh.ma_monhoc like ?1")
    Optional<Monhoc> findByMaMH(String maMH);

    @Query(nativeQuery = true,value = " select * from monhoc as mh where mh.ma_monhoc=?1")
    Optional<Monhoc> findMamonHocOp(String maMonHoc);
}
