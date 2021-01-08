package com.blogger.blog.service;

import com.blogger.blog.model.Blog;
import com.blogger.blog.model.Comment;

import com.blogger.blog.repository.BlogRepository;
import com.blogger.blog.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BlogRepository blogRepository;

    public List<Comment> listAll() {
        return commentRepository.findAll();
    }


    public Comment get(Long id) {
        return commentRepository.findById(id).get();
    }
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    public void save(Comment comment, Blog blog) {
        comment.setBlog(blogRepository.getOne(blog.getId()));
        commentRepository.save(comment);

    }    public void saveWithBlogAndComment(Comment comment, Blog blogId, Long commentId) {
        comment.setBlog(blogRepository.getOne(blogId.getId()));
        comment.setId(commentId);
        commentRepository.save(comment);

    }

}
