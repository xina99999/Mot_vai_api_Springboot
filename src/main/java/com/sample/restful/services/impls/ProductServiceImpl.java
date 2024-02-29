package com.sample.restful.services.impls;

import com.sample.restful.entities.Product;
import com.sample.restful.models.requests.SaveProductRequest;
import com.sample.restful.repositories.ProductRepository;
import com.sample.restful.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        if (id == null) { return null; }
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(SaveProductRequest request) {
        Product product = findById(request.getId());
        if (product == null){
            product = new Product();
        }

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setShort_Description(request.getShort_Description());
        product.setLong_Description(request.getLong_Description());
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }


}
