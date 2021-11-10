/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiroas.repository.sql;

import com.tiroas.repository.sql.orm.Product;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface ProductCrudRepository extends MongoRepository<Product, Integer> {
    List<Product> findByPrecioLessThanEqual(double precio);

    List<Product> findByCategoria(String categoria);

    @Query("{'nombre':{'$regex':'?0','$options':'i'}}")
    List<Product> findByNombreLike(String nombre);
}
