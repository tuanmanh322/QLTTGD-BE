package com.da.repository;

import com.da.model.RolesControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesControlRepository extends JpaRepository<RolesControl, Integer>, JpaSpecificationExecutor<RolesControl> {

}
