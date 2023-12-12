package com.doan2.project_pizzahub.repository;


import com.doan2.project_pizzahub.dto.UserDTO;
import com.doan2.project_pizzahub.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
//
//    /**
//     * select * users where username='' and password= ''
//     * @param username
//     * @param password
//     * @return
//     */

//    List<Users> findByUserName(String username, String password);
    Users findByUserName(String userName);
}
