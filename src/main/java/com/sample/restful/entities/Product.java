package com.sample.restful.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name ="Product"
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "Short_Description")
    private  String Short_Description;

    @Column(name = "Long_Description")
    private String Long_Description;

    @Column(name = "Price")
    private  Long Price;

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        Price = price;
    }

    public Product() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
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
}
