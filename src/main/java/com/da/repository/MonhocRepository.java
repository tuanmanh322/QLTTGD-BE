package com.da.repository;

import com.da.model.Monhoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MonhocRepository extends JpaRepository<Monhoc, Integer>, JpaSpecificationExecutor<Monhoc> {
    @Query(nativeQuery = true,value = " select * from monhoc as mh where mh.ma_monhoc=?1")
    Monhoc findByTenmonhoc(String tenMonHoc);

    @Query(nativeQuery = true, value = "SELECT * from monhoc as mh where mh.ma_monhoc like ?1")
    Monhoc findByMaMH(Integer maMH);
}
