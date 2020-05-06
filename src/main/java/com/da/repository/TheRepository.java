package com.da.repository;

import com.da.model.The;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheRepository extends JpaRepository<The, Integer>, JpaSpecificationExecutor<The> {
    @Query(nativeQuery = true, value = "select  th from the as th where th.ma_the=?1")
    Optional<The> findByMaThe(String maThe);
}
