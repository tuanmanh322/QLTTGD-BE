package com.da.repository;

import com.da.model.Actions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionsRepository extends JpaRepository<Actions,Integer> {
}
