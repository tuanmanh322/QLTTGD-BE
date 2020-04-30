package com.da.repository;

import com.da.model.GroupNhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsNhanVienRepository extends JpaRepository<GroupNhanVien,Integer> {
}
