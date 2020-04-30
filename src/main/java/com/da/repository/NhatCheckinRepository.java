package com.da.repository;

import com.da.model.NhatCheckin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhatCheckinRepository extends JpaRepository<NhatCheckin,Integer> {
}
