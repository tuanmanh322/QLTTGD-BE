package com.da.repository;

import com.da.model.Loaithe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaitheRepository extends JpaRepository<Loaithe, Integer>, JpaSpecificationExecutor<Loaithe> {

}
