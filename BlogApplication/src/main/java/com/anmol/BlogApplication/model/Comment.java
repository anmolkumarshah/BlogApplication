package com.anmol.BlogApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String content;

    @CreationTimestamp
    Date timestamp;

    @ManyToOne
    @JsonIgnore
    Blog blog;

    // for setting the Blog
    @Transient
    Long bid;

    // by user
    @ManyToOne
    @JsonIgnore
    User user;

    // for setting the user
    @Transient
    Long uid;

}
