package com.example.productservice_proxy.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public abstract class BaseModel {
    private long id;
    private Date createdAt;
    private Date lastUpdate;
    private boolean isDeleted;

}
