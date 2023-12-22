//package com.doan2.project_pizzahub.controller;
//
//import com.doan2.project_pizzahub.payload.ResponseData;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@CrossOrigin("*")
//@RestController
//@RequestMapping("/menu")
//public class MenuController {
//
//    @PostMapping()
//    public ResponseEntity<?> createMenu(
//            @RequestParam MultipartFile file,
//            @RequestParam String title,
//            @RequestParam String is_freeship,
//            @RequestParam String time_ship,
//            @RequestParam String price,
//            @RequestParam int cate_id) {
//
//        ResponseData responseData = new ResponseData();
//        boolean isSuccess = restaurantServiceImp.insertRestaurant(file, title, subtitle, description, is_freeship, address, open_date);
//        responseData.setData(isSuccess);
//
//        return new ResponseEntity<>(responseData, HttpStatus.OK);
//    }
//}
