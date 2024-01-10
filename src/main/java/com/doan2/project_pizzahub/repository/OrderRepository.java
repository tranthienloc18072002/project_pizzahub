package com.doan2.project_pizzahub.repository;

import com.doan2.project_pizzahub.entity.Orders;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
