package com.albanero.homeassignment.Repository;

import com.albanero.homeassignment.Entity.TableInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableInfoRepository extends JpaRepository<TableInfo, Integer> {
}
