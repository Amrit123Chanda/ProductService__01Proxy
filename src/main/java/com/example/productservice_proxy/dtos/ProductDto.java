package com.example.productservice_proxy.dtos;

import com.example.productservice_proxy.models.Categories;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProductDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String Image;
    private RatingDto rating ;

}
