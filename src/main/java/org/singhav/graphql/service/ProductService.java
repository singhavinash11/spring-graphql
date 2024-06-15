package org.singhav.graphql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.singhav.graphql.dto.Product;
import org.singhav.graphql.entity.ProductEntity;
import org.singhav.graphql.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ObjectMapper objectMapper;
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<ProductEntity> existingProducts = productRepository.findAll();
        return existingProducts.stream()
                .map(productEntity -> objectMapper.convertValue(productEntity, Product.class))
                .toList();
    }

    public List<Product> getProductsByCategory(String category) {
        List<ProductEntity> existingProductsByCategory = productRepository.findByCategoryIgnoreCase(category);
        return existingProductsByCategory.stream()
                .map(productEntity -> objectMapper.convertValue(productEntity, Product.class))
                .toList();
    }

    public Product updateStock(int id, int stock) {
        ProductEntity existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("product not found with id " + id));
        existingProduct.setStock(stock);
        productRepository.save(existingProduct);
        return objectMapper.convertValue(existingProduct, Product.class);
    }

    public Product receiveNewShipment(int id, int quantity) {
        ProductEntity existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("product not found with id " + id));
        existingProduct.setStock(existingProduct.getStock() + quantity);
        productRepository.save(existingProduct);
        return objectMapper.convertValue(existingProduct, Product.class);
    }
}