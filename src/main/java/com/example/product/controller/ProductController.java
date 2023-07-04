package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

@GetMapping("/allProduct")
public List<Product> getAllProducts() {
    return productService.getAllProducts();
}

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        return productService.updateProduct(productId, updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam("productName") String productName) {
        return productService.searchProductsByName(productName);
    }

}
