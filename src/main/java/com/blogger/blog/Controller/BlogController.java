package com.blogger.blog.Controller;

import com.blogger.blog.Repository.UserRepository;
import com.blogger.blog.entity.Blog;
import com.blogger.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService service;
    private UserRepository repo;
    @RequestMapping("/blogs")
    public String viewBlogs(Model model) {
        List<Blog> blogList = service.listAll();
        model.addAttribute("blogList", blogList);
        return "blogs";
    }
    @RequestMapping("/")
    public String viewHomeBlogs(Model model) {
        List<Blog> blogList = service.listAll();
        model.addAttribute("blogList", blogList);
        return "home";
    }
    @RequestMapping("/new")
    public String newBlog(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "new_blog";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBlog(@ModelAttribute("blog") Blog blog) {
        service.save(blog);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editBlog(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_blog");

        Blog blog = service.get(id);
        mav.addObject("blog", blog);
        return mav;
    }


}