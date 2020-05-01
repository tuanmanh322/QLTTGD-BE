package com.da.repository;

import com.da.model.RolesAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesActionRepository extends JpaRepository<RolesAction, Integer>, JpaSpecificationExecutor<RolesAction> {

}
