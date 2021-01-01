package com.blogger.blog.service;

import com.blogger.blog.Repository.BlogRepository;
import com.blogger.blog.Repository.UserRepository;
import com.blogger.blog.entity.Blog;
import com.blogger.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void save(User content) {
        userRepository.save(content);
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
