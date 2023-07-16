package com.anmol.BlogApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String email;

    String password;

    @OneToMany(mappedBy = "user")
    List<Blog> blogs = List.of();

    @OneToMany(mappedBy = "user")
    List<Comment> comments = List.of();

    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roles;

}
