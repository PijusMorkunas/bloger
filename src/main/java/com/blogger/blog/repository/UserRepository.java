package com.blogger.blog.repository;

import com.blogger.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
     User findByUsername(String username);
    @Query("SELECT u FROM User u WHERE u.username = :username")
     User getUserByUsername(String username);

}