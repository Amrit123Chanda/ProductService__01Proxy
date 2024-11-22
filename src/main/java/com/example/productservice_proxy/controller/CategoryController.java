package com.example.productservice_proxy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    @GetMapping("")
    public String getAllCategories()
    {
    return "Get all Categpries1";
    }
    @GetMapping("/{categoryId}")
    public String getProductsInCategories(@PathVariable("categoryId") Long categoryId)
    {
    return "Get Product category";
    }

}

