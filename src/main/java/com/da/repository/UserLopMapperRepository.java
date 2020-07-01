package com.da.repository;

import com.da.model.UserLopMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLopMapperRepository extends JpaRepository<UserLopMapper, Integer>, JpaSpecificationExecutor<UserLopMapper> {
    @Query(nativeQuery = true, value = "SELECT * FROM user_lop_mapper as ulm where ulm.id_user=?1 and ulm.id_lop=?2 and ulm.trangthai = 1")
    UserLopMapper findByUserAndLop(Integer idUser, Integer idLop);

    @Query(nativeQuery = true, value = "SELECT distinct * FROM user_lop_mapper as ulm where ulm.id_user=?1 and ulm.trangthai = 1")
    List<UserLopMapper> findByIdUser(Integer idUser);

    @Query(nativeQuery = true, value = "SELECT * FROM user_lop_mapper as ulm where ulm.id_user=?1 and ulm.id_lop=?2")
    Optional<UserLopMapper> checkUserAndLop(Integer idUser, Integer idLop);
}
