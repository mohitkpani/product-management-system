package com.example.productmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productmanagementsystem.entity.Product;
import com.example.productmanagementsystem.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productrepo;
	
	//SAVE PRODUCT
	public Product saveProduct(Product product) {
		return productrepo.save(product);
	}
	
	//GET ALL PRODUCT
	public List<Product> getAllProducts(){
		return productrepo.findAll();
	}
	
	
	//GET PRODUCTS BY ID
	public Product findProductById(Long id) {
		 Optional<Product> product = productrepo.findById(id);
		 if(product.isPresent()) {
			 return product.get();
		 } else {
			 return null;
		 }
		  
	}
	
	
	//UPDATE PRODUCT
	public Product updateProduct(Long id, Product updatedProduct) {
		 Product existingProduct = productrepo.findById(id).orElse(null);
		 
		 if(existingProduct != null) {
			 existingProduct.setName(updatedProduct.getName());
			 existingProduct.setPrice(updatedProduct.getPrice());
			 existingProduct.setQuantity(updatedProduct.getQuantity());
			 
			 return productrepo.save(existingProduct);
		 }
		 return null;
	}
	
	//DELETE PRODUCT
	public String deleteProduct(Long id) {
		Product product = productrepo.findById(id).orElse(null);
		if(product != null) {
			productrepo.deleteById(id);
			return "Product deleted successfully";
		} else {
			return "Product not found";
		}
	}
}
