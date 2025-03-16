package com.example.productservice_proxy.repositories;

import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ToString

class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Test
    void saveproductandcategory() {
        Categories categories = new Categories();
        categories.setName("Electronic");
        categories.setDescription("Electronics");
        categoryRepo.save(categories);

        Product product=new Product();
        product.setTitle("Laptop");
        product.setDescription("Laptops");
        product.setCategory(categories);
        productRepo.save(product);

        Categories categories1 = categoryRepo.findById(categories.getId());
        System.out.println("Debug");

    }

    @Test
    @Transactional
    @Rollback(value = false)
    void saveproductsandcategory3()
    {
        Categories category = categoryRepo.findById(1L);

        Product product = new Product();
        product.setPrice(1012);
        product.setImageUrl("Hellow");
        product.setCategory(category);
        Product saveProduct = productRepo.save(product);
        System.out.println("1st is saved");
        product = new Product();
        product.setPrice(1013);
        product.setImageUrl("Hello");
        product.setCategory(category);
        productRepo.save(product);
        System.out.println("2nd is saved");

    }

    @Test
    @Transactional
    void saveproductsandcategory4()
    {
       Product product = productRepo.findProductById(152L);
       System.out.println("Debug");
    }
}