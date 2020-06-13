package com.da.repository;

import com.da.model.Hangmuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HangMucRepository  extends JpaRepository<Hangmuc, Integer>, JpaSpecificationExecutor<Hangmuc> {

    @Query(nativeQuery = true, value = "select * from hangmuc as hm where hm.ma_monhoc=?1")
    Hangmuc findByMaMonhoc(Integer maMH);
}
