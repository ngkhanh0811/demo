package com.example.springdemo.repository;/*Welcome to my show !

@author: NgKhanh
Date: 6/23/2023
Time: 7:47 PM

ProjectName: spring-demo*/

import com.example.springdemo.dto.ProductStatic;
import com.example.springdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.lang.annotation.Native;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor {
//    Optional<List<Product>> findProductByName(String name);
//    Product getById(long id);
//    Product createItem(Product product);
//    @Query("from Product p where p.productName = :name")
//    @Query(value = "select * from product where productName =:name limit :pageSize offset :offset", nativeQuery = true)
//    Optional<Product> findByN(@Param("name") String productName,@Param("pageSize") int pageSize,@Param("offset") int offset);
//
//    @Query("select new ProductStatic(p.productName) from Product p join Producer pr where pr.id = p.producer.id and where p.name =:name")
//    Optional<ProductStatic> findProductStatic(@Param("name") String productName);
@Query(value = "from  product p where p.name =:productName")
Optional<Product> findByName(@Param("productName") String productName);

//@Query("select new ProductStatic(p.productName) from Product p join Producer pr where pr.id = p.producer.id and where p.name =:name");
//Optional<ProductStatic> findProductStatic(@Param("name") String name);
 }