package com.doan2.project_pizzahub.service;

import com.doan2.project_pizzahub.entity.Category;
import com.doan2.project_pizzahub.entity.Food;
import com.doan2.project_pizzahub.entity.Restaurant;
import com.doan2.project_pizzahub.repository.FoodRepository;
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

    @Autowired
    FoodRepository foodRepository;

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

                Category category = new Category();
                category.setId(cate_id);

                food.setCategory(category);

                foodRepository.save(food);

                isInsertSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Error insert restaurant: " + e.getMessage());
        }


        return isInsertSuccess;

    }
}
