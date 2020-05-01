package com.da.repository;

import com.da.model.Chude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChudeRepository extends JpaRepository<Chude, Integer>, JpaSpecificationExecutor<Chude> {

}
