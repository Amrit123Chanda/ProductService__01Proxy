package com.example.productservice_proxy.models;

import com.example.productservice_proxy.dtos.RatingDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity // 11/2/25 :Marks a class as a database table.
public class Product extends BaseModel {
    private String title;
    private double price;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Categories  category;
    private String imageUrl;

}
