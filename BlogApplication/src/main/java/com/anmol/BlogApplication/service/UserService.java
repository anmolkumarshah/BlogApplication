package com.anmol.BlogApplication.service;

import com.anmol.BlogApplication.model.User;
import com.anmol.BlogApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User getById(Long id){
        // todo : here also
        return userRepository.findById(id).get();
    }

    public  User getByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
