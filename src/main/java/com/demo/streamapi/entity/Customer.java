package com.demo.streamapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Integer tier;

}