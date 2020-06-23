package com.da.repository;

import com.da.model.Repcomment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepcommentRepository extends JpaRepository<Repcomment, Integer>, JpaSpecificationExecutor<Repcomment> {

    @Query(nativeQuery = true, value = "select * from repcomment as re where re.id_comment=?1 order by re.created_date desc")
    List<Repcomment> findByIdComment(Integer idComment);

    List<Repcomment> findByIdUser(Integer idUser);
}

