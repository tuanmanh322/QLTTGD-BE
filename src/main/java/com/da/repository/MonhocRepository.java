package com.da.repository;

import com.da.model.Monhoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MonhocRepository extends JpaRepository<Monhoc, Integer>, JpaSpecificationExecutor<Monhoc> {

}
