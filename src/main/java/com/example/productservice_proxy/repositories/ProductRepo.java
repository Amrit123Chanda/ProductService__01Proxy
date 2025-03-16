package com.example.productservice_proxy.repositories;

import com.example.productservice_proxy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
   // Product save(Product product); //11/2/25save is method JPA repository interface 11/2/25: The save() method is commonly used in frameworks like Spring Data JPA or Hibernate to store or update data in a database.
    /*
save():Purpose: It saves (inserts or updates) an entity (a Java object) into the database. save() automatically saves to the database defined in application.properties.
Behavior:
If the entity does not exist in the database, it performs an INSERT operation.
If the entity already exists, it performs an UPDATE operation.
Insert: When you pass a new object (one without an ID or primary key), save() will insert it as a new record in the database.
Update: When you pass an existing object (one with an ID or primary key), save() will update the corresponding record in the database.
JpaRepository<T, ID> is a generic interface where:
T → The entity type (Product in this case).
ID → The type of the primary key (Long in this case).
     */

    Product findProductById(Long Id);
}
