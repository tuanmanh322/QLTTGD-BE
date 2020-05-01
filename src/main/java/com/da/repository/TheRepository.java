package com.da.repository;

import com.da.model.The;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TheRepository extends JpaRepository<The, Integer>, JpaSpecificationExecutor<The> {

}
