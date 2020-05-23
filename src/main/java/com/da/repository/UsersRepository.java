package com.da.repository;

import com.da.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

    @Query(nativeQuery = true, value = "select * from users AS  u where  u.ma_the=?1")
    Users findByMaThe(Integer maThe);
}
