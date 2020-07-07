package com.da.repository;

import com.da.model.Baiviet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaivietRepository extends JpaRepository<Baiviet, Integer>, JpaSpecificationExecutor<Baiviet> {

    @Query(nativeQuery = true, value = "select * from baiviet as bv where bv.ma_chude=?1 order by bv.created_date desc")
    List<Baiviet> findByMaChuDe(Integer idMaChuDe);

    @Query(nativeQuery = true, value = "SELECT * from baiviet as bv where bv.id_the=?1")
    List<Baiviet> getListBVByIdUser(Integer idUser);

    @Query(nativeQuery = true, value = "SELECT * from baiviet as bv where bv.trangthai=1")
    List<Baiviet> countBV();
}
