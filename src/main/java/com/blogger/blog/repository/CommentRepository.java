package com.blogger.blog.repository;

import com.blogger.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.beans.Transient;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Transient
    @Modifying
    @Query("delete from Comment u where u.blog.Id = ?1")
    void deleteByBlogId(Long id);

}
