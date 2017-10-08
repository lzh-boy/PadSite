package com.pad.blog.controller;

import com.pad.blog.BlogConstants;
import com.pad.blog.entity.Blog;
import com.pad.common.FlexibleUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pad on 17-9-28.
 * blog action
 */
@Controller
@RequestMapping("/blog")
public class BlogController implements BlogConstants{


    @GetMapping("/list")
    public String getBlogList(Model model){
        List<Blog> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            Blog blog=new Blog();
            blog.setId(i+ FlexibleUtils.parseToHtml("# id"));
            blog.setContent("cont"+i);
            blog.setTitle("ti"+i);
            list.add(blog);
        }
        model.addAttribute("list",list);
        return VIEW_PATH+"blog_list";
    }
}
