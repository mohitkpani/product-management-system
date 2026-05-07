package com.example.productmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productmanagementsystem.entity.Product;
import com.example.productmanagementsystem.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//ADD PRODUCT
	@PostMapping
	public Product addProduct(@Valid @RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	//GET ALL PRODUCT
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	
	//GET PRODUCTS BY ID
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}
	
	
	//UPDATE PRODUCT
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id,@Valid @RequestBody Product updateProduct) {
		return productService.updateProduct(id, updateProduct);
	}
	
	
	//DELETE PRODUCT
	@DeleteMapping("/{id}")
	public String deleteproduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}	
	
}
