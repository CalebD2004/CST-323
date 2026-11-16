package com.activity2.cloudproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity2.cloudproject.models.product;
import com.activity2.cloudproject.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Method to retrieve all products from the database
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to save a product to the database
    public product saveProduct(product product) {
        return productRepository.save(product);
    }

    public product updateProduct(product product) {
        product productToBeUpdated = productRepository.findById(product.getId())
        .orElseThrow(() -> new RuntimeException("Product not found with id: " + product.getId()));

        productToBeUpdated.setName(product.getName());
        productToBeUpdated.setQuantity(product.getQuantity());
        productToBeUpdated.setPrice(product.getPrice());

        return productRepository.save(productToBeUpdated);
    }


    public product getProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
