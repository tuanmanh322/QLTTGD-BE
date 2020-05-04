package com.da.repository;

import com.da.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>, JpaSpecificationExecutor<Roles> {
    @Query(nativeQuery = true, value = "select ro from roles as ro where ro.name_role=?1")
    Optional<Roles> findByRole(String role);
}
