/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiroas.service.impl;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.tiroas.repository.sql.orm.Product;
import com.tiroas.repository.sql.ProductAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tiroas.service.api.IProductService;
import com.tiroas.service.port.ProductPort;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductService {

    private final ProductPort productPort;
    private final MongoTemplate mongoTemplate;


    public ProductService(ProductAdapter productPort, MongoTemplate mongoTemplate) {
        this.productPort = productPort;
        this.mongoTemplate = mongoTemplate;
    }

    public Product createProduct(Product product) {
        return productPort.createProduct(product);
    }

    public Product updateProduct(Product product) {

        if (product.getId() != null) {
            Optional<Product> productoDb = productPort.getProductById(product.getId());
            if (productoDb.isPresent()) {
                if (product.getNombre() != null) {
                    productoDb.get().setNombre(product.getNombre());
                }
                if (product.getCategoria() != null) {
                    productoDb.get().setCategoria(product.getCategoria());
                }
                if (product.getDescripcion() != null) {
                    productoDb.get().setDescripcion(product.getDescripcion());
                }
                if (product.getCantidad() != 0) {
                    productoDb.get().setCantidad(product.getCantidad());
                }
                if (product.getPrecio() != 0.0) {
                    productoDb.get().setPrecio(product.getPrecio());
                }
                productPort.updateProduct(productoDb.get());
                return productoDb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public List<Product> getAllProduct() {
        return this.productPort.getAllProduct();
    }

    public Optional<Product> getProductById(int productId) {

        return this.productPort.getProductById(productId);
    }

    public boolean deleteProduct(int productId) {
        return getProductById(productId).map(product -> {
            productPort.deleteProduct(product);
            return true;
        }).orElse(false);
    }

    public List<Product> productsByPricing(double pricing) {
        return productPort.productsByPricing(pricing);
    }

    public List<Product> productsByCategory(String category) {
        return productPort.productsByCategory(category);
    }

    public List<Product> productsByName(String name) {
        return productPort.productsByName(name);
    }

    public List<String> getAllCategories() {
        List<String> categoryList = new ArrayList<>();
        MongoCollection<Document> mongoCollection = mongoTemplate.getCollection("productos");
        DistinctIterable<String> distinctIterable = mongoCollection.distinct("categoria", String.class);
        for (String o : distinctIterable) {
            categoryList.add(o);
        }
        return categoryList;
    }
}
