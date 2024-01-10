package com.doan2.project_pizzahub.service;

import com.doan2.project_pizzahub.dto.CategoryDTO;
import com.doan2.project_pizzahub.dto.MenuDTO;
import com.doan2.project_pizzahub.entity.Category;
import com.doan2.project_pizzahub.entity.Food;
import com.doan2.project_pizzahub.repository.CategoryRepository;
import com.doan2.project_pizzahub.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getCategoryHomePage() {
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("id"));
        Page<Category> listCategory = categoryRepository.findAll(pageRequest);
        List<CategoryDTO> listcategoryDTOS = new ArrayList<>();

        for (Category data: listCategory
             ) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(data.getNameCate());

            List<MenuDTO> menuDTOS = new ArrayList<>();

            for (Food dataFood:data.getListFood()
                 ) {
                MenuDTO menuDTO = new MenuDTO();
                menuDTO.setTitle(dataFood.getTitle());
                menuDTO.setFreeship(dataFood.isFreeShip());
                menuDTO.setImage(dataFood.getImage());

                menuDTOS.add(menuDTO);
            }
            categoryDTO.setMenus(menuDTOS);

            listcategoryDTOS.add(categoryDTO);
        }

        return listcategoryDTOS;
    }
}
