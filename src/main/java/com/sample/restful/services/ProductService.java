package com.sample.restful.services;

import com.sample.restful.entities.Product;
import com.sample.restful.models.requests.SaveProductRequest;

import java.util.List;

public interface ProductService {
    Product findById(Long id);
    List<Product> findAll();
    Product save(SaveProductRequest request);
    void delete(Product product);


}
