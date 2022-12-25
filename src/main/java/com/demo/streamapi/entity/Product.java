package com.demo.streamapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String category;
    @With private Double price;

    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    private Set<Order> orders;

}