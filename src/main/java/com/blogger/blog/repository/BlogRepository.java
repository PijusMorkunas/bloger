package com.blogger.blog.repository;

import com.blogger.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {


}
