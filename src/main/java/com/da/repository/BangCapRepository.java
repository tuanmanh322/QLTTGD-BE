package com.da.repository;

import com.da.model.BangCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BangCapRepository extends JpaRepository<BangCap,Integer> {
}
