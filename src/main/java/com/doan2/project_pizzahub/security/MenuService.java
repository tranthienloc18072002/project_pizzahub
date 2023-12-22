package com.doan2.project_pizzahub.security;

import com.doan2.project_pizzahub.entity.Food;
import com.doan2.project_pizzahub.entity.Restaurant;
import com.doan2.project_pizzahub.service.imp.FileServiceImp;
import com.doan2.project_pizzahub.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MenuService implements MenuServiceImp {

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean createMenu(MultipartFile file, String title, String is_freeship, String time_ship, double price, int cate_id) {

        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess) {
                Food food = new Food();
                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setTimeShip(time_ship);
                food.setPrice(price);
                isInsertSuccess = true;
            }
        } catch (Exception e){
            System.out.println("Error insert restaurant" + e.getMessage());
        }
        return isInsertSuccess;

    }
}
