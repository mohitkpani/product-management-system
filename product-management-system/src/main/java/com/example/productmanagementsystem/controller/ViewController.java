package com.example.productmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.productmanagementsystem.entity.Product;
import com.example.productmanagementsystem.service.ProductService;

@Controller
public class ViewController {

    @Autowired
    private ProductService productService;

    // HOME PAGE
    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    // ADD PRODUCT PAGE
    @GetMapping("/add-product")
    public String addProductpage() {
        return "add-product";
    }

    // SAVE PRODUCT
    @PostMapping("/save-product")
    public String addProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/add-product?success";
    }

    // VIEW ALL PRODUCTS
    @GetMapping("/products-ui")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    // VIEW PRODUCT BY ID
    @GetMapping("/product-by-id")
    public String viewProductById(Long id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "product-details";
    }

    // SEARCH PRODUCT PAGE
    @GetMapping("/search-product")
    public String searchProductPage() {

        return "search-product";
    }

    // UPDATE PRODUCT PAGE
    @GetMapping("/update-product")
    public String updateProductPage() {
        return "update-product";
    }

    // UPDATE PRODUCT
    @PostMapping("/update-product-data")
    public String updateProduct(Product product) {
        productService.updateProduct(product.getId(), product);
        return "redirect:/products-ui";
    }

    // DELETE PRODUCT PAGE
    @GetMapping("/delete-product")
    public String deleteProductPage() {
        return "delete-product";
    }

    // DELETE PRODUCT
    @PostMapping("/delete-product-data")
    public String deleteProduct(Long id, Model model) {
       String message = productService.deleteProduct(id);
       model.addAttribute("message", message);
        return "delete-product";
    }
    
    //LOGIN PAGE
    @GetMapping("/login")
    public String loginPage() {
    	return "login";
    }

}