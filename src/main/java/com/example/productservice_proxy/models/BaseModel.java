package com.example.productservice_proxy.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass //the fields in this baseModel superclass will be treated as columns in its child class entity table but BaseModel itself is not an entity
public abstract class BaseModel {
    @Id //11/2/25: Marks a field as the primary key.
    @GeneratedValue(strategy = GenerationType.AUTO)/*11/2/25 @GeneratedValue: Automatically generates the primary key value.
    GenerationType.AUTO lets the JPA provider (e.g., Hibernate, EclipseLink) decide the best strategy for generating primary key values.
The JPA provider will look at the database and choose the most appropriate strategy based on the database and configuration.
*/
    private Long id;
    private Date createdAt;
    private Date lastUpdate;
    private boolean isDeleted;

}
