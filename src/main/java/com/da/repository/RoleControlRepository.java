package com.da.repository;

import com.da.model.RoleControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleControlRepository extends JpaRepository<RoleControl,Integer> {
}
