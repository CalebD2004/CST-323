package com.activity2.cloudproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.activity2.cloudproject.models.product;

public interface ProductRepository extends JpaRepository<product, Long> {
    
}
