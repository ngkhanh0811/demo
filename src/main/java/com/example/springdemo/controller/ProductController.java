package com.example.springdemo.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/23/2023
Time: 8:15 PM

ProjectName: spring-demo*/

import com.example.springdemo.dto.ProductDto;
import com.example.springdemo.service.ProductService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "api/v1")
public class ProductController extends BaseController{
    private static Logger logger = LogManager.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;
    @PostMapping(value = "/products")
    public ResponseEntity<?> gets(@RequestBody ProductDto criteria, HttpServletRequest request){
//        if (criteria.getPageSize() == null ||  criteria.getPageSize() <= 0) {
//            criteria.setPageSize(commonProperties.getDefaultPageSize());
//        }
//        if (criteria.getPageNumber() == null || criteria.getPageNumber() < 0) {
//            criteria.setPageNumber(commonProperties.getDefaultPageNumber());
//        }
            return ResponseEntity.ok(productService.gets(criteria));
    }
    @GetMapping(value = "/findProductByName")
    public ResponseEntity<?> findProductByName(@RequestParam String productName, HttpServletRequest request){
        long startTime = System.currentTimeMillis();
        ProductDto productDto = productService.findByName(productName);
        long endTime = System.currentTimeMillis();
        System.err.println("Time process = " + (endTime-startTime));
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/product")
    public ResponseEntity<?> get(@RequestParam Long id, HttpServletRequest request){
        logger.info("Process: request product by productId = {}", id);
        ProductDto productDto = productService.getById(id);
        return ResponseEntity.ok(productDto);
    }


    @PostMapping("/create")
    public ResponseEntity<ProductDto> get(@ModelAttribute ProductDto productDto, HttpServletRequest request){
        ProductDto product = productService.save(productDto);
        return ResponseEntity.ok(product);
    }
}
