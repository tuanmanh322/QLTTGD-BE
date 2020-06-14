package com.da.repository;

import com.da.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>, JpaSpecificationExecutor<Document> {

    @Query(nativeQuery = true, value = "select * from document as dc where dc.id=?1")
    Document findByIdA(Integer idDC);
}
