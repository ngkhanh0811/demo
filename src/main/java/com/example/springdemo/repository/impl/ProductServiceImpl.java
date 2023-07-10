package com.example.springdemo.repository.impl;/*Welcome to my show !

@author: NgKhanh
Date: 6/23/2023
Time: 8:10 PM

ProjectName: spring-demo*/

import com.example.springdemo.dto.ProductDto;
import com.example.springdemo.entity.Product;
import com.example.springdemo.mapper.ProductMapper;
import com.example.springdemo.repository.ProductRepository;
import com.example.springdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper mapper;
    @Autowired
    private ProductRepository repo;
    @Override
    public List<ProductDto> gets(ProductDto criteria) {
        Pageable pageable = PageRequest.of(criteria.getPageNumber(), criteria.getPageSize());
        Page<Product> productList = repo.findAll(pageable);
        return productList.getContent()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findByName(String productName) {
        Optional<Product> p = repo.findByName(productName);
        return p.isPresent()?mapper.entityToDto(p.get()) : null;
    }

    @Override
    public ProductDto getById(Long id) {
        // todo: validate...
        return mapper.entityToDto(repo.getById(id));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        // if primary key existed -> update
        // if primary key value is null -> add
       Product product = mapper.dtoToEntity(productDto);
       if (Objects.isNull(product)){
           return null;
       } else{
//           return Optional.ofNullable(repo.save(product)).map(mapper::entityToDto).orElse(null);
           Product returnEntity = repo.save(product);
           return mapper.entityToDto(returnEntity);
       }
    }

    @Override
    public ProductDto createNewItem(String name, String price) {
//        ProductDto productDto1 = new ProductDto();
//        productDto1.getId();
        return null;
    }

}
