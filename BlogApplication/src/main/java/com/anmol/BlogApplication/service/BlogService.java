package com.anmol.BlogApplication.service;

import com.anmol.BlogApplication.model.Blog;
import com.anmol.BlogApplication.model.Tag;
import com.anmol.BlogApplication.model.User;
import com.anmol.BlogApplication.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    TagService tagService;

    @Autowired
    UserService userService;

    public Blog save(Blog blog){
        if(blog.getUid() != null){
            User byId = userService.getById(blog.getUid());
            blog.setUser(byId);
        }

        String[] split = blog.getTagsId().split(",");
        List<Tag> tagList;
        try {
            tagList = Arrays.stream(split).map(el -> tagService.getById(Long.parseLong(el))).toList();
        }catch (NumberFormatException ex){
            tagList = List.of();
        }
        tagList.forEach(tag -> tag.addBlog(blog));

        blog.setTags(tagList);
        return  blogRepository.save(blog);
    }

    public  Blog findById(Long id){
        //  TODO: HANDLE IT FOR NOT GETTING BLOG
        return blogRepository.findById(id).get();
    }

}
