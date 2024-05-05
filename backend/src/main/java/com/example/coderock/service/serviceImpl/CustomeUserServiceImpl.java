package com.example.coderock.service.serviceImpl;

import com.example.coderock.service.serviceInfs.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceInterface userServiceInterface;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userServiceInterface.getUserByUserName(username);
    }
}
