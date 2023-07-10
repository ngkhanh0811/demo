package com.example.springdemo.filter;/*Welcome to my show !

@author: NgKhanh
Date: 6/30/2023
Time: 7:18 PM

ProjectName: spring-demo*/

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/common/sidebar.jsp")
                .addExcludedPath("/login")
                .addExcludedPath("/passwordChange");
    }
}
