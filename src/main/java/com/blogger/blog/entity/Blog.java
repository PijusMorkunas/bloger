package com.blogger.blog.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Service
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String content;
    private String comment;
    private Long user_Id;

    //public or protected?
    public Blog() {
    }

}