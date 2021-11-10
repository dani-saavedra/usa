/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiroas.repository.sql;

import com.tiroas.repository.sql.orm.Product;
import com.tiroas.service.port.ProductPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductAdapter implements ProductPort {

    private final ProductCrudRepository productCrudRepository;

    public ProductAdapter(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    public Product createProduct(Product Product) {
        return productCrudRepository.save(Product);
    }

    public void updateProduct(Product product) {
        productCrudRepository.save(product);
    }

    public List<Product> getAllProduct() {
        return productCrudRepository.findAll();
    }

    public Optional<Product> getProductById(int productId) {
        return productCrudRepository.findById(productId);
    }

    public void deleteProduct(Product product) {
        productCrudRepository.delete(product);
    }

    public List<Product> productsByPricing(double precio) {
        return productCrudRepository.findByPrecioLessThanEqual(precio);
    }

    public List<Product> productsByCategory(String categoria) {
        return productCrudRepository.findByCategoria(categoria);
    }

    public List<Product> productsByName(String nombre) {
        return productCrudRepository.findByNombreLike(nombre);
    }

}
