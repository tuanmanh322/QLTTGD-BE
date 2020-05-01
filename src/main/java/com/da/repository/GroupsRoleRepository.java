package com.da.repository;

import com.da.model.GroupsRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRoleRepository extends JpaRepository<GroupsRole, Integer>, JpaSpecificationExecutor<GroupsRole> {

}
