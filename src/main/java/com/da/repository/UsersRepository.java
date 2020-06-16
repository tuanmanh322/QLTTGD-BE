package com.da.repository;

import com.da.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

    @Query(nativeQuery = true, value = "select * from users AS  u where  u.ma_the=?1")
    Users findByMaThe(Integer maThe);

    @Query(nativeQuery = true, value = "select * from users AS  u where  u.email=?1")
    Optional<Users> findByEmail(String email);

    @Query(nativeQuery = true, value = "select * from users AS  u where  u.name like ?1")
    Optional<Users> findByName(String name);
}
