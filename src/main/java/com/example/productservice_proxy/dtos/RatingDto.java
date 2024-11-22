package com.example.productservice_proxy.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class RatingDto {
    private double rate;
    private double count;
}
