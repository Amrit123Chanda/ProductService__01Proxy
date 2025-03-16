package com.example.productservice_proxy.repositories;

import com.example.productservice_proxy.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Categories,Long> {

    Categories save(Categories categories);

    Categories findById(long id);
    /*
    When you call findById(), Spring Data JPA:Generates the SQL query to fetch the entity by its primary key (id).Executes the query against the database.Returns the result as an Optional<T> (where T is the entity type, in this case, Categories).
     */
}
