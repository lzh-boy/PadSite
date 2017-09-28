package com.pad.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pad on 17-9-28.
 * blog action
 */
@Controller
@RequestMapping("/blog")
public class BlogController {


    @GetMapping("/list")
    public String getBlogList(){

        return "list";
    }
}
