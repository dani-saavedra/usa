/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiroas.service.port;

import com.tiroas.repository.sql.orm.Product;

import java.util.List;
import java.util.Optional;


public interface ProductPort {

    Product createProduct(Product Product);

    void updateProduct(Product product);

    List<Product> getAllProduct();

    Optional<Product> getProductById(int productId);

    void deleteProduct(Product product);

    List<Product> productsByPricing(double pricing);

    List<Product> productsByCategory(String category);

    List<Product> productsByName(String name);
}