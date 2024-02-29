package com.sample.restful.models.responses;

import com.sample.restful.entities.Product;

public class ProductDTO {
    private Long id;

    private String name;

    private String description;
    private String Short_Description;

    private String Long_Description;

    private Long Price;

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public String getShort_Description() {
        return Short_Description;
    }

    public void setShort_Description(String short_Description) {
        Short_Description = short_Description;
    }

    public String getLong_Description() {
        return Long_Description;
    }

    public void setLong_Description(String long_Description) {
        Long_Description = long_Description;
    }

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ProductDTO from(Product product){
        ProductDTO response = new ProductDTO();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setShort_Description(product.getShort_Description());
        response.setLong_Description(product.getLong_Description());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        return response;
    }
}
