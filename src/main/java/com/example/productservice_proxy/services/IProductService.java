package com.example.productservice_proxy.services;

import com.example.productservice_proxy.clients.IClientProductDto;
import com.example.productservice_proxy.models.Product;

import java.util.List;

public interface IProductService {
    Product getSingleProduct(Long productId);

    List<Product> getAllProducts();

    //Product addNewProduct(IClientProductDto productDto);

    //Product addNewProduct(Product product);

    Product addNewProduct(Product product);



    Product updateProduct(Long productId, Product product);

    String deleteProductDe(Long productId);

    String patchProduct(Long productId);
}
