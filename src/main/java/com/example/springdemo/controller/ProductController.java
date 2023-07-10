package com.example.springdemo.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/23/2023
Time: 8:15 PM

ProjectName: spring-demo*/

import com.example.springdemo.dto.ProductDto;
import com.example.springdemo.entity.Product;
import com.example.springdemo.repository.impl.ProductServiceImpl;
import com.example.springdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
public class ProductController extends BaseController{
    @Autowired
    private ProductService productService;
    @GetMapping(value = "/products")
    public ModelAndView gets(HttpServletRequest request){
        ProductDto criteria = new ProductDto();
            criteria.setPageSize(commonProperties.getDefaultPageSize());
            criteria.setPageNumber(commonProperties.getDefaultPageNumber());
            ModelAndView view = new ModelAndView("pages/list.jsp");
            List<ProductDto> products = productService.gets(criteria);
            view.addObject("products", products);
            return view;
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
    public ModelAndView get(@RequestParam Long id, HttpServletRequest request){
        ModelAndView view = new ModelAndView("pages/details.jsp");
        ProductDto productDto = productService.getById(id);
        view.addObject("product", productDto);
        return view;
    }

    @GetMapping("/create")
    public ModelAndView get(@RequestParam ProductDto productDto, Long id, HttpServletRequest request){
        ProductDto product = new ProductDto();
        if (!Objects.isNull(id) && id > 0){
            product = productService.getById(id);
        }
        ModelAndView view = new ModelAndView("pages/createForm.jsp");
        view.addObject("product", product);
        return view;
    }

    @PostMapping("/create")
    public ModelAndView get(@RequestBody ProductDto productDto, HttpServletRequest request){
        ProductDto product = productService.save(productDto);
        if (Objects.isNull(product)){
            ModelAndView view = new ModelAndView("pages/createForm.jsp");
            return view;
        }
        ModelAndView view = new ModelAndView("pages/createForm.jsp");
        view.addObject("productDto", product);
        return view;
    }
}
