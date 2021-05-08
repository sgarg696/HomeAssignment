package com.albanero.homeassignment.Repository;

import com.albanero.homeassignment.Entity.ColumnInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnInfoRepository extends JpaRepository<ColumnInfo, Integer> {
}
