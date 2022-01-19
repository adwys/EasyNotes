package com.Easynotes.services;

import com.Easynotes.models.UserModel;
import com.Easynotes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServices implements UserDetailsService {

    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user;
        if(repository.findByUsername(username).isPresent()){
            user = repository.findByUsername(username).get();
        }
        else{
            return null;
        }
        return new User(user.getUsername(),user.getPassword(), new ArrayList<>());
    }
}
