package com.da.repository;

import com.da.model.UserLopMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserLopMapperRepository extends JpaRepository<UserLopMapper, Integer>, JpaSpecificationExecutor<UserLopMapper> {

}
