package com.example.springdemo.entity;/*Welcome to my show !

@author: NgKhanh
Date: 6/23/2023
Time: 7:16 PM

ProjectName: spring-demo*/

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;

    //format
    @Column(name = "inserted_date")
    private LocalDateTime insertedTime;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
    @Column(name = "updated_by")
    private String updatedBy;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "producer_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Producer producer;

    @PrePersist
    private void beforeInsert(){
        this.insertedTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    @PreUpdate
    private void beforeUpdate(){
        this.updatedTime = LocalDateTime.now();
    }
}