package com.example.springdemo.service;/*Welcome to my show !

@author: NgKhanh
Date: 6/23/2023
Time: 8:09 PM

ProjectName: spring-demo*/

import com.example.springdemo.dto.ProductDto;
import com.example.springdemo.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {
    List<ProductDto> gets(ProductDto criteria); // không lấy get all (hoặc hiếm khi) -> phân trang
//    Product getById(long id);
//    Product createItem(Product product);
    ProductDto findByName(String productName);
    ProductDto getById(Long id);
    ProductDto save(ProductDto product);
    ProductDto createNewItem(String name, String price);
}