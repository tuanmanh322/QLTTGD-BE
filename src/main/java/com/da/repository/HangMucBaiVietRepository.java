package com.da.repository;

import com.da.model.HangMucBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangMucBaiVietRepository extends JpaRepository<HangMucBaiViet,Integer> {
}
