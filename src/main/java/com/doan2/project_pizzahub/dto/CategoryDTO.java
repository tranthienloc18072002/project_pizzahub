package com.doan2.project_pizzahub.dto;

import java.util.List;

public class CategoryDTO {
    private String name;
    private List<MenuDTO> menus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuDTO> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDTO> menus) {
        this.menus = menus;
    }
}
