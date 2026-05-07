package com.example.productmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagementsystem.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
