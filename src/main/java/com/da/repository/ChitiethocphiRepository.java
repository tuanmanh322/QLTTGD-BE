package com.da.repository;

import com.da.model.Chitiethocphi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChitiethocphiRepository extends JpaRepository<Chitiethocphi, Integer>, JpaSpecificationExecutor<Chitiethocphi> {

}
