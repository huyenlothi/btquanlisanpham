package com.example.demo.controller;

import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/")
    public ModelAndView getCategory(){
        ModelAndView modelAndView = new ModelAndView("category");
        modelAndView.addObject("listCategory",categoryService.findAll());
        return modelAndView;
    }

}
