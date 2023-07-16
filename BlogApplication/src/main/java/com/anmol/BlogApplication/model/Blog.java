package com.anmol.BlogApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Blog_Table")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;

    String content;

    @CreationTimestamp
    Date timestamp;

    // list of tags

    @ManyToMany(mappedBy = "blogs")
    List<Tag> tags;

    @Transient
    String tagsId; // in format 1,2 ...

    // list of comments

    @OneToMany(mappedBy = "blog")
    List<Comment> comments;

    // created by user
    @ManyToOne
    @JsonIgnore
    User user;

    // for setting the user
    @Transient
    Long uid;

}
