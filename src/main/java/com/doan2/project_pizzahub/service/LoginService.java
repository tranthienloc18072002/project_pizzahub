package com.doan2.project_pizzahub.service;

import com.doan2.project_pizzahub.dto.UserDTO;
import com.doan2.project_pizzahub.entity.Roles;
import com.doan2.project_pizzahub.entity.Users;
import com.doan2.project_pizzahub.payload.request.SignUpRequest;
import com.doan2.project_pizzahub.repository.UserRepository;
import com.doan2.project_pizzahub.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImp {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUser() {

        List<Users> listUser = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (Users users: listUser) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setUserName(users.getUserName());
            userDTO.setFullname(users.getFullname());
            userDTO.setPassword(users.getPassword());

            userDTOList.add(userDTO);

        }

        return userDTOList;
    }

    @Override
    public boolean checkLogin(String username, String password) {

        Users user = userRepository.findByUserName(username);

        return passwordEncoder.matches(password,user.getPassword());


    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {

        Roles roles = new Roles();
        roles.setId(signUpRequest.getRoleId());
        Users users = new Users();

        users.setFullname(signUpRequest.getFullname());
        users.setUserName(signUpRequest.getEmail());
        users.setPassword(signUpRequest.getPassword());
        users.setRoles(roles);
        try{
            userRepository.save(users);

            return true;
        }catch (Exception e) {
            return false;
        }


    }


}
