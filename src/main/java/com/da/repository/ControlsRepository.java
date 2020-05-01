package com.da.repository;

import com.da.model.Controls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlsRepository extends JpaRepository<Controls, Integer>, JpaSpecificationExecutor<Controls> {

}
