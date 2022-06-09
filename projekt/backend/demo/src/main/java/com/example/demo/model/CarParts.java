package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class CarParts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String imageUrl;
    private String code;

    public CarParts() {}

    public CarParts(String name, String description, Integer price, String imageUrl, Long code) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCode() {
        return code;
    }
    public String setCode(String code) {
        return this.code = code;
    }


    @Override
    public String toString() {
        return "CarParts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}