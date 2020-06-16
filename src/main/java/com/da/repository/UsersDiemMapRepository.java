package com.da.repository;

import com.da.model.UsersDiemMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsersDiemMapRepository extends JpaRepository<UsersDiemMap, Integer>, JpaSpecificationExecutor<UsersDiemMap> {

}
