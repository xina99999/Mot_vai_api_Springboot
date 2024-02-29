package com.sample.restful.repositories;

import com.sample.restful.entities.Product;
import com.sample.restful.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
