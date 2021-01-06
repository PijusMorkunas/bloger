package com.blogger.blog.Controller;

import com.blogger.blog.entity.Blog;
import com.blogger.blog.entity.Comment;

import com.blogger.blog.service.BlogService;
import com.blogger.blog.service.CommentService;
import com.blogger.blog.userDetails.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/blogs")
    public String viewBlogs(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        List<Blog> blogList = blogService.listAll();
        model.addAttribute("blogList", blogList);
        List<Comment> commentList = commentService.listAll();
        model.addAttribute("commentList", commentList);

        String username = customUserDetails.getUsername();
        model.addAttribute("username", username);
        return "blogs";
    }

    @RequestMapping("/")
    public String viewHomeBlogs(Model model, HttpServletRequest request) {
//        Locale currentLocale = request.getLocale();
//        String countryCode = currentLocale.getCountry();
//        String countryName = currentLocale.getDisplayCountry();
//        String langCode = currentLocale.getLanguage();
//        String langName = currentLocale.getDisplayLanguage();
//        System.out.println(countryCode + ":" + countryName);
//        System.out.println(langCode + ":" + langName);

        List<Blog> blogList = blogService.listAll();
        model.addAttribute("blogList", blogList);
        return "home";
    }

    @RequestMapping("/new")
    public String newBlog(Model model) {

        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        return "new_blog";

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBlog(@ModelAttribute("blog") Blog blog, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        blogService.save(blog, customUserDetails.getUser());
        return "redirect:/blogs";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editBlog(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_blog");

        Blog blog = blogService.get(id);
        mav.addObject("blog", blog);

        return mav;
    }
        @RequestMapping(value = "/saveCommentWithBlogId/{blogId}/{commentId}", method = RequestMethod.POST)
    public String saveCommentWithBlogId(@ModelAttribute("comment") Comment comment,
                                        @PathVariable(name = "blogId") Blog blogId, @PathVariable(name = "commentId") Long commentId) {
        commentService.saveWithBlogAndComment(comment, blogId, commentId);
        return "redirect:/blogs";
    }


    @RequestMapping("/editComment/{blogId}/{commentId}")
    public ModelAndView editComment(@PathVariable(name = "blogId") Long blogId, @PathVariable(name = "commentId") Long commentId) {
        ModelAndView mav = new ModelAndView("edit_comment");

      Comment comment = commentService.get(commentId);
        mav.addObject("comment", comment);
        Blog blog = blogService.get(blogId);
        mav.addObject("blog", blog);

        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteBlog(@PathVariable(name = "id") Long id) {

        blogService.delete(id);
        return "redirect:/blogs";

    }


        @RequestMapping(value = "/saveComment/{id}", method = RequestMethod.POST)
        public String saveComment(@ModelAttribute("comment") Comment comment, @PathVariable(name = "id") Blog id) {
            commentService.save(comment, id);
            return "redirect:/blogs";
        }


        @RequestMapping("/newComment/{id}")
        public String newComment(Model model, @PathVariable(name = "id") Long id, Comment comment, Blog blog) {
            model.addAttribute("comment", comment);
            model.addAttribute("blog", blog);
            model.addAttribute("id", id);
            return "new_comment";

        }

        @RequestMapping("/deleteComment/{id}")
        public String deleteComment(@PathVariable(name = "id") Long id) {
            commentService.delete(id);
            return "redirect:/blogs";
        }
    @RequestMapping("/?=lang=en")
    public String languageEnglish() {

        return "redirect:/";

    }    @RequestMapping("/?=lang=lt")
    public String languageLithuanian() {

        return "redirect:/";
    }

    }


