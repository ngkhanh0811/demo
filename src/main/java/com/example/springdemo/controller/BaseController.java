package com.example.springdemo.controller;/*Welcome to my show !

@author: NgKhanh
Date: 6/28/2023
Time: 7:03 PM

ProjectName: spring-demo*/

import com.example.springdemo.config.properties.CommonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    @Autowired
    protected CommonProperties commonProperties;
}
