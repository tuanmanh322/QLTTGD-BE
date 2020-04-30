package com.da.repository;

import com.da.model.GroupHocSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsHocSinhRepository extends JpaRepository<GroupHocSinh,Integer> {
}
