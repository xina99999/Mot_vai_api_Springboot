package com.sample.restful.controllers;

import com.sample.restful.entities.Product;
import com.sample.restful.models.requests.SaveProductRequest;
import com.sample.restful.models.responses.ProductDTO;
import com.sample.restful.models.responses.show_info_ProductDTO;
import com.sample.restful.services.ProductService;
import org.apache.naming.HandlerRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping("/save")
    ResponseEntity<ProductDTO> save(@RequestBody SaveProductRequest request) {
        Product product1= productService.findById(request.getId());
        if(product1 == null) {
            Product savedProduct = productService.save(request);
            return new ResponseEntity<>(ProductDTO.from(savedProduct), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    //show ten gia va trich dan nho
    @PostMapping("show/mini/{id}")
    ResponseEntity<show_info_ProductDTO> showmini(@RequestParam("id") Long id )
    {
        Product product = productService.findById(id);
        if(product != null)
        {

            return  new ResponseEntity<>(show_info_ProductDTO.from(product),HttpStatus.OK);
        }
        else
        {
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping("/delete")
    ResponseEntity<Void> delete(@RequestParam("id") Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            productService.delete(product);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/list")
    ResponseEntity<List<ProductDTO>> list() {
        List<ProductDTO> products = productService.findAll().stream().map(ProductDTO::from).toList();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @PostMapping("/detail/{id}")
    ResponseEntity<ProductDTO> detail(@RequestParam("id") Long id) {
        Product product = productService.findById(id);
        if (product != null){
            return new ResponseEntity<>(ProductDTO.from(product), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
