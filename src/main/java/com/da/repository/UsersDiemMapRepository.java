package com.da.repository;

import com.da.model.UsersDiemMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDiemMapRepository extends JpaRepository<UsersDiemMap, Integer>, JpaSpecificationExecutor<UsersDiemMap> {
    @Query(nativeQuery = true, value = "SELECT * FROM users_diem_map as udm where udm.id_user=?1")
     UsersDiemMap findByIdUSer(Integer idUser);

    @Query(nativeQuery = true, value = "SELECT * FROM users_diem_map as udm where udm.id_diem=?1")
    UsersDiemMap findWithIdDiem(Integer idDiem);
}
