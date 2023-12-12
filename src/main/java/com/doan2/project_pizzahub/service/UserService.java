package com.doan2.project_pizzahub.service;

import com.doan2.project_pizzahub.dto.UserDTO;
import com.doan2.project_pizzahub.entity.Users;
import com.doan2.project_pizzahub.repository.UserRepository;
import com.doan2.project_pizzahub.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    UserRepository userRepository;

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
}
