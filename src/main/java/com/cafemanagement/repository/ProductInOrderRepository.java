package com.cafemanagement.repository;

import com.cafemanagement.entity.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder,Long> {
}
