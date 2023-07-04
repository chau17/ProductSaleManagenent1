package com.example.product.service;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {

        return productRepository.save(product);

    }
    public Product updateProduct(Long productId, Product updatedProduct) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            product.setProductName(updatedProduct.getProductName());
            product.setDescription(updatedProduct.getDescription());
            product.setBasePrice(updatedProduct.getBasePrice());
            product.setCreatedDate(updatedProduct.getCreatedDate());
            product.setModifiedDate(updatedProduct.getModifiedDate());
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }


    public List<Product> searchProductsByName(String productName) {
        return productRepository.findByProductName(productName);
    }


}
