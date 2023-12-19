package com.doan2.project_pizzahub.controller;

import com.doan2.project_pizzahub.payload.ResponseData;
import com.doan2.project_pizzahub.service.imp.FileServiceImp;
import com.doan2.project_pizzahub.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    RestaurantServiceImp restaurantServiceImp;

    @PostMapping()
    public ResponseEntity<?> createRestaurant(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam String subtitle,
            @RequestParam String description,
            @RequestParam boolean is_freeship,
            @RequestParam String address,
            @RequestParam String open_date) {

        ResponseData responseData = new ResponseData();
        boolean isSuccess = restaurantServiceImp.insertRestaurant(file, title, subtitle, description, is_freeship, address, open_date);
        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getHomeRestaurant() {

        ResponseData responseData = new ResponseData();
        responseData.setData(restaurantServiceImp.getHomePageRestaurant());


        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String fileName) {

         Resource resource = fileServiceImp.loadFile(fileName);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);

    }
}
