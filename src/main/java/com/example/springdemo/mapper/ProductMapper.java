package com.example.springdemo.mapper;/*Welcome to my show !

@author: NgKhanh
Date: 6/23/2023
Time: 8:26 PM

ProjectName: spring-demo*/

import com.example.springdemo.dto.ProductDto;
import com.example.springdemo.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product dtoToEntity(ProductDto productDto);
    ProductDto entityToDto(Product product);
}