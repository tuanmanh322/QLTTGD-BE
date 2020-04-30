package com.da.repository;

import com.da.model.Control;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlRepository extends JpaRepository<Control,Integer> {
}
