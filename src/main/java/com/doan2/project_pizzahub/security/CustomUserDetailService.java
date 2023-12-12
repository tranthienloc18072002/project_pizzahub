package com.doan2.project_pizzahub.security;

import com.doan2.project_pizzahub.entity.Users;
import com.doan2.project_pizzahub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userRepository.findByUserName(username);
        if (users == null) {
            throw new UsernameNotFoundException("User can't exit");
        }

        return new User(username,users.getPassword(),new ArrayList<>());
    }
}
