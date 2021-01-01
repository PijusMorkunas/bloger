package com.blogger.blog.service;

import com.blogger.blog.Repository.BlogRepository;
import com.blogger.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> listAll() {
        return blogRepository.findAll();
    }

    public void save(Blog content) {
        blogRepository.save(content);
    }

    public Blog get(Long id) {
        return blogRepository.findById(id).get();
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
}
