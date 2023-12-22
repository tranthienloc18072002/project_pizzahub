package com.doan2.project_pizzahub.service.imp;

import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImp {
         boolean createMenu(MultipartFile file,String title,String is_freeship,String time_ship,double price,int cate_id);
}
