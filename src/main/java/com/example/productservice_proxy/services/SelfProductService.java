package com.example.productservice_proxy.services;

import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements IProductService{

    ProductRepo productRepo;

    public SelfProductService(ProductRepo productRepo)
    {
        this.productRepo=productRepo;
        /*
        @Service is a specialization of @Component, meaning it marks the class as a Spring-managed bean.
        It is typically used to define business logic (services).
        When a class annotated with @Service has dependencies in its constructor, Spring automatically injects them.
        @Service itself does not perform dependency injection, but it registers the class as a Spring Bean, allowing Spring to inject dependencies automatically.
         */
    }
    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        this.productRepo.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public String deleteProductDe(Long productId) {
        return null;
    }

    @Override
    public String patchProduct(Long productId) {
        return null;
    }
}
