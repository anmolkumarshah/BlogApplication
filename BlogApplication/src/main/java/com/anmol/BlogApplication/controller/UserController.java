package com.anmol.BlogApplication.controller;

import com.anmol.BlogApplication.dto.UserDTO;
import com.anmol.BlogApplication.model.User;
import com.anmol.BlogApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder encoder;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        User saved = userService.save(user);
        UserDTO userDTO = UserDTO.builder().name(user.getName()).email(user.getEmail()).blogs(user.getBlogs()).comments(user.getComments()).id(user.getId()).build();
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        UserDTO userDTO = UserDTO.builder().name(user.getName()).email(user.getEmail()).blogs(user.getBlogs()).comments(user.getComments()).id(user.getId()).build();
        return ResponseEntity.ok(userDTO);
    }

}
