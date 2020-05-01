package com.da.repository;

import com.da.model.Nhatcheckin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NhatcheckinRepository extends JpaRepository<Nhatcheckin, Integer>, JpaSpecificationExecutor<Nhatcheckin> {

}
