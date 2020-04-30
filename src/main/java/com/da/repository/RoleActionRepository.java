package com.da.repository;

import com.da.model.RoleAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleActionRepository extends JpaRepository<RoleAction,Integer> {
}
