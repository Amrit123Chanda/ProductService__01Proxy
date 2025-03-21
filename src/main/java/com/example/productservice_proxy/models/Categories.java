package com.example.productservice_proxy.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
@ToString

public class Categories extends BaseModel{
    private String name;
    private String description;
    @OneToMany(mappedBy = "category" , fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private List<Product> productList;
}
