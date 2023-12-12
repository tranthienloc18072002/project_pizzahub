package com.doan2.project_pizzahub.service.imp;

import com.doan2.project_pizzahub.dto.UserDTO;
import com.doan2.project_pizzahub.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServiceImp {

    List<UserDTO> getAllUser();
    boolean checkLogin(String username, String password);
    boolean addUser(SignUpRequest signUpRequest);

}
