package com.da.repository;

import com.da.model.GroupRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRoleRepository extends JpaRepository<GroupRole,Integer> {
}
