package com.da.repository;

import com.da.model.Repcomment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepcommentRepository extends JpaRepository<Repcomment, Integer>, JpaSpecificationExecutor<Repcomment> {

}
