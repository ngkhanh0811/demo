package com.example.springdemo.spec;

import com.example.springdemo.dto.ProductDto;
import com.example.springdemo.entity.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSpecification {
    public Specification<Product> filter(final ProductDto criteria){
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            // if name exists -> search by name
            if (StringUtils.isNotEmpty(criteria.getName())){
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + criteria.getName().toUpperCase() + "%"));
            }
            if (criteria.getMaxPrice() > 0){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), criteria.getMaxPrice()));
            }

            if (criteria.getMinPrice() > 0){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), criteria.getMinPrice()));
            }
            return criteriaBuilder.and(predicates.stream()
                    .toArray(Predicate[]::new));
        };
    }
}
