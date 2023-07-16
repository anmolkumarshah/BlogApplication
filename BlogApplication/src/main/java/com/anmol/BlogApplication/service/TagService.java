package com.anmol.BlogApplication.service;

import com.anmol.BlogApplication.model.Tag;
import com.anmol.BlogApplication.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public Tag save(Tag tag) {
        tag.setName(tag.getName().toUpperCase());
        return tagRepository.save(tag);
    }

    public Tag getById(Long id){
        // todo: handle it
        return tagRepository.findById(id).get();
    }

    public List<Tag> getAllTags(){
        return  tagRepository.findAll();
    }

}
