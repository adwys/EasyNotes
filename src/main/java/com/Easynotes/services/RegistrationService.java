package com.Easynotes.services;

import com.Easynotes.filters.EmailValidator;
import com.Easynotes.models.RegisterRequest;
import com.Easynotes.models.UserModel;
import com.Easynotes.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserRepository repository;

    private final EmailValidator emailValidator;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<?> register(RegisterRequest request){
        UserModel user;
        try {
            user = new UserModel(request.getUsername(),request.getPassword(),request.getEmail());
        }catch (Exception e){
            return new ResponseEntity<>("bad body", HttpStatus.BAD_REQUEST);
        }

        if(repository.findByEmail(user.getEmail()).isPresent()){
            return new ResponseEntity<>("user already exist", HttpStatus.BAD_REQUEST);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
        return new ResponseEntity<>("user added", HttpStatus.CREATED);
    }

}
