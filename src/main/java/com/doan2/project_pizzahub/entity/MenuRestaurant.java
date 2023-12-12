package com.doan2.project_pizzahub.entity;

import com.doan2.project_pizzahub.entity.keys.KeyMenuRestaurant;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity(name = "menu_restaurant")
public class MenuRestaurant {

    @EmbeddedId
    KeyMenuRestaurant keys;

    @ManyToOne
    @JoinColumn(name = "cate_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Restaurant restaurant;

    @Column(name = "create_date")
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public KeyMenuRestaurant getKeys() {
        return keys;
    }

    public void setKeys(KeyMenuRestaurant keys) {
        this.keys = keys;
    }






}
