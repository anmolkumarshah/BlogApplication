package com.anmol.BlogApplication.service;

import com.anmol.BlogApplication.model.Blog;
import com.anmol.BlogApplication.model.Comment;
import com.anmol.BlogApplication.model.User;
import com.anmol.BlogApplication.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    public Comment save(Comment comment){
        if(comment.getUid() != null){
            User byId = userService.getById(comment.getUid());
            comment.setUser(byId);
        }
        Blog byId = blogService.findById(comment.getBid());
        comment.setBlog(byId);
        return  commentRepository.save(comment);
    }
}
