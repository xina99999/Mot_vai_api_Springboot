package com.sample.restful.models.responses;

import com.sample.restful.entities.Product;

public class show_info_ProductDTO {
    private Long id;

    private String name;
    private String Short_Description;

    private  Long Price;

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
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

    public String getShort_Description() {
        return Short_Description;
    }

    public void setShort_Description(String short_Description) {
        Short_Description = short_Description;
    }

    public  show_info_ProductDTO()
    {}

    public static show_info_ProductDTO from(Product product){
        show_info_ProductDTO response = new show_info_ProductDTO();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setShort_Description(product.getShort_Description());
        response.setPrice(product.getPrice());
        return response;
    }
}
