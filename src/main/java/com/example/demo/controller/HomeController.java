package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.category.ICategoryService;
import com.example.demo.service.product.IProductService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.SecureRandom;

@Controller
@RequestMapping("/product")
public class HomeController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute("categorys")
    Iterable<Category> category(){
        return categoryService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("listProduct",productService.findAll());
        return modelAndView;
    }
    @GetMapping()
    public ResponseEntity<Iterable<Product>> getAll(){
        return  new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productService.findById(id).get();
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Product product){
        ModelAndView modelAndView= new ModelAndView("edit");
        productService.save(product);
        modelAndView.addObject("product" , product);
        return modelAndView;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/khongcoquyen")
    public String khongcoquyen(){
        return "khongcoquyen";
    }

}
