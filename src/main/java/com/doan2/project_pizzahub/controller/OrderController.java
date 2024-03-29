package com.doan2.project_pizzahub.controller;

import com.doan2.project_pizzahub.payload.request.OrderRequest;
import com.doan2.project_pizzahub.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImp orderServiceImp;

    @PostMapping
    public ResponseEntity<?> getAllUser(@RequestBody OrderRequest orderRequest) {

        return new ResponseEntity<>(orderServiceImp.insertOrder(orderRequest), HttpStatus.OK);
    }
}
