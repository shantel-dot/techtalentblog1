package com.techtalentsouth.techtalentblog.controller;


import com.techtalentsouth.techtalentblog.model.BlogPost;
import com.techtalentsouth.techtalentblog.repo.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
    //@Autowired allows us to implement whats known as dependency injection.
    // Dependency injection allows us to give certain objects the dependencies that it needs.
    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping("/")
    public String index(BlogPost blogPost) {
        //since we are utilize thymeleaf
        // our output will be generated in a template
        // returning a reference to said template
        // will allow us to show the data that we want
            return "blogpost/index";
        }
    private BlogPost blogPost;

    @PostMapping(value = "/")
    public String addNewBlogPost(BlogPost blogPost, Model model) {
        blogPostRepository.save
                (new BlogPost(blogPost.getTitle(),
                        blogPost.getAuthor(),
                        blogPost.getBlogEntry()
                ));

        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }
    }

