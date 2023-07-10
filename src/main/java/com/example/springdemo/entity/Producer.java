package com.example.springdemo.entity;/*Welcome to my show !

@author: NgKhanh
Date: 6/26/2023
Time: 9:05 PM

ProjectName: spring-demo*/


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity(name = "producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "producer_name", nullable = false)
    private String producerName;
    @Column(name = "address", nullable = false)
    private String address;
    @OneToMany(mappedBy = "producer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Product> products;
}
