package com.doan2.project_pizzahub.repository;

import com.doan2.project_pizzahub.entity.OrderItem;
import com.doan2.project_pizzahub.entity.keys.KeyOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, KeyOrderItem> {
}
