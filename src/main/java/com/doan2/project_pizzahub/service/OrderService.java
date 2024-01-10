package com.doan2.project_pizzahub.service;

import com.doan2.project_pizzahub.entity.*;
import com.doan2.project_pizzahub.entity.keys.KeyOrderItem;
import com.doan2.project_pizzahub.payload.request.OrderRequest;
import com.doan2.project_pizzahub.repository.OrderItemRepository;
import com.doan2.project_pizzahub.repository.OrderRepository;
import com.doan2.project_pizzahub.service.imp.OrderServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OrderService implements OrderServiceImp {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;


    @Override
    public boolean insertOrder(OrderRequest orderRequest) {

        try {
            Users users = new Users();
            users.setId(orderRequest.getUserId());

            Restaurant restaurant = new Restaurant();
            restaurant.setId(orderRequest.getRestId());


            Orders orders = new Orders();
            orders.setUsers(users);
            orders.setRestaurant(restaurant);

            orderRepository.save(orders);

            List<OrderItem> items = new ArrayList<>();

            for (int idFood: orderRequest.getFoodIds()
            ) {

                Food food = new Food();
                food.setId(idFood);

                OrderItem orderItem = new OrderItem();
                KeyOrderItem keyOrderItem = new KeyOrderItem(orders.getId(),idFood);
                orderItem.setKeyOrderItem(keyOrderItem);

                items.add(orderItem);

            }
            orderItemRepository.saveAll(items);

            return true;

        }catch (Exception e) {
            System.out.println("Error insert order" + e.getMessage());
            return false;
        }




    }
}
