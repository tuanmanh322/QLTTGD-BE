package com.da.repository;

import com.da.model.TrinhDoNgoaiNgu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrinhDoNgoaiNguRepository extends JpaRepository<TrinhDoNgoaiNgu,Integer> {
}
