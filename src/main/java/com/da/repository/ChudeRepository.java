package com.da.repository;

import com.da.model.Chude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChudeRepository extends JpaRepository<Chude, Integer>, JpaSpecificationExecutor<Chude> {
    @Query(nativeQuery = true, value = "select *from chude as cd where cd.id_hangmuc=?1")
    List<Chude> getALLbYiDhANGmUC(Integer idHm);
}
