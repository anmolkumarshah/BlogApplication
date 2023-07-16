package com.anmol.BlogApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    // list of blog many to many bidirectional
    @ManyToMany
    @JsonIgnore
    List<Blog> blogs;

    public void addBlog(Blog blog){
        blogs.add(blog);
    }

}
