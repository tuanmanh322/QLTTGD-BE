package com.da.repository;

import com.da.model.Baiviet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BaivietRepository extends JpaRepository<Baiviet, Integer>, JpaSpecificationExecutor<Baiviet> {

}
