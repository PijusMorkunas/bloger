package com.blogger.blog.service;

import com.blogger.blog.repository.BlogRepository;
import com.blogger.blog.repository.UserRepository;
import com.blogger.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BlogService blogService;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void save(User content) {
        userRepository.save(content);
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }
}