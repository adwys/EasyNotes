package com.Easynotes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServices implements UserDetailsService {

    @Value("test.username")
    private String username;

    @Value("test.password")
    private String password;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(this.username,password, new ArrayList<>());
    }
}
