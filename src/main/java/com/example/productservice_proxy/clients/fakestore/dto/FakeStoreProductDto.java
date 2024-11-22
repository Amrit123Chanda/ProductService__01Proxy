package com.example.productservice_proxy.clients.fakestore.dto;

import com.example.productservice_proxy.clients.IClientProductDto;
import com.example.productservice_proxy.dtos.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class FakeStoreProductDto implements IClientProductDto{


        private long id;
        private String title;
        private double price;
        private String description;
        private String category;
        private String Image;
        private RatingDto rating ;

    }


