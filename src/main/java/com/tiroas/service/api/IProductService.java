package com.tiroas.service.api;

import com.tiroas.repository.sql.orm.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    List<Product> getAllProduct();

    Optional<Product> getProductById(int productId);

    boolean deleteProduct(int productId);

    List<Product> productsByPricing(double pricing);

    List<Product> productsByCategory(String category);

    List<Product> productsByName(String name);

    List<String> getAllCategories();
}
