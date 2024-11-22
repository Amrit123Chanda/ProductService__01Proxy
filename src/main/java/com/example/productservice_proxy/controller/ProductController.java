package com.example.productservice_proxy.controller;

import com.example.productservice_proxy.clients.IClientProductDto;
import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController  {

    IProductService productService;

    public ProductController(IProductService productService)
    {
        this.productService=productService;
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("Id") Long productId )
    {
        try{
            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add("Accept", "application/JSON");
            headers.add("Content-type","Application/JSON");
            headers.add("Auth-token","heyAccess");
            Product product=this.productService.getSingleProduct(productId);
            if(productId<1)
            { throw new IllegalAccessException("Something went wrong");}
            ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,headers,HttpStatus.valueOf(200));
            return responseEntity;
        }

        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.valueOf(404));
        }
    }
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts()
        {
            List<Product> productList = this.productService.getAllProducts();
            return new ResponseEntity<>( productList,HttpStatus.valueOf(200));
            //return responseEntity;
        }
        @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody IClientProductDto productDto )
    {       Product product=this.productService.addNewProduct(productDto);
            ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,HttpStatus.OK);

             return  responseEntity;
    }
    @PostMapping("/{Id}")
    public String updateProduct(@PathVariable("Id") Long productId )
    {
        return "update Product " + productId;
    }
    @DeleteMapping("/{Id}")
    public String deleteProductDe(@PathVariable("Id") Long productId )
    {
        return "deleting product " + productId;
    }
    @PatchMapping("/{Id}")
    public Product patchProduct(@PathVariable("Id") Long productId, @RequestBody ProductDto productDto)
    {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(new Categories());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        return this.productService.updateProduct(productId,product);
    }
}
