package com.example.productservice_proxy.models;

import com.example.productservice_proxy.dtos.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product extends BaseModel {
    private String title;
    private double price;
    private String description;
    private Categories  category;
    private String imageUrl;

}
