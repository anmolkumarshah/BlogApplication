package com.anmol.BlogApplication.dto;

import com.anmol.BlogApplication.model.Blog;
import com.anmol.BlogApplication.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    Long id;
    String name;
    String email;
    List<Blog> blogs;
    List<Comment> comments;
}
