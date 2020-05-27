package com.da.repository;

import com.da.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {

    @Query(nativeQuery = true, value = "select * from comment as cm where cm.id_baiviet=?1")
    List<Comment> findByIdBaiViet(Integer idBaiViet);
}
