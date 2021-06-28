package com.nexus.test.controller;

import com.nexus.test.models.Product;
import com.nexus.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product productDetails) {
    System.out.println(productDetails);
        Product product = new Product();
        product.setQuantity(productDetails.getQuantity());
        product.setAdmissionDate(productDetails.getAdmissionDate());
        product.setName(productDetails.getName());
        product.setUserRecord(productDetails.getUserRecord());
        product.setUserUpdate(productDetails.getUserRecord());
        return productRepository.save(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product productDetails) {
        System.out.println(productDetails);
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

        product.setName(productDetails.getName());
        product.setUserUpdate(productDetails.getUserUpdate());
        product.setUpdatedAt(productDetails.getUpdatedAt());
        product.setQuantity(productDetails.getQuantity());
        System.out.println(product);
        final Product productUpdated = productRepository.save(product);
        System.out.println(productUpdated);
        return ResponseEntity.ok(productUpdated);
    }

    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable("id") int id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
