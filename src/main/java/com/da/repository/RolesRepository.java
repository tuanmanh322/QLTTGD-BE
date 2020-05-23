package com.da.repository;

import com.da.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>, JpaSpecificationExecutor<Roles> {
    @Query(nativeQuery = true, value = "select * from roles as ro where ro.id=?1 and ro.id_role=?2")
    Optional<Roles> findByRole(Integer idRole, String roleType);
}
