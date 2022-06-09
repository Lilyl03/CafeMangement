package com.cafemanagement.repository;

import com.cafemanagement.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table,Long> {
}
