package com.example.springdemo.dto;/*Welcome to my show !

@author: NgKhanh
Date: 6/23/2023
Time: 8:24 PM

ProjectName: spring-demo*/

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto extends PageDto {
    private long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime insertedTime;
    private String createdBy;
    private LocalDateTime updatedTime;
    private String updatedBy;
}
