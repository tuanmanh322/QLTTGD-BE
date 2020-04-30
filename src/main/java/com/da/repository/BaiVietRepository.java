package com.da.repository;

import com.da.model.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiVietRepository extends JpaRepository<BaiViet,Integer> {
}
