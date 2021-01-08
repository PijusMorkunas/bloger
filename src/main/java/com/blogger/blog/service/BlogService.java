package com.blogger.blog.service;

import com.blogger.blog.repository.BlogRepository;
import com.blogger.blog.repository.CommentRepository;
import com.blogger.blog.repository.UserRepository;
import com.blogger.blog.model.Blog;
import com.blogger.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService  {
    @Autowired
    private BlogRepository blogRepository;
  @Autowired
    private UserRepository userRepository;
  @Autowired
    private CommentRepository commentRepository;



    public List<Blog> listAll() {
        return blogRepository.findAll();
    }

    public void save(Blog content, User user) {
        content.setUser(userRepository.getOne(user.getId()));
        blogRepository.save(content);

    }
    public Blog get(Long id) {
        return blogRepository.findById(id).get();
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }





}
