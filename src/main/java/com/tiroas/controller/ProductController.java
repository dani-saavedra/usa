/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiroas.controller;

import com.tiroas.controller.dto.ProductoDTO;
import com.tiroas.repository.sql.orm.Product;
import com.tiroas.service.api.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/productos")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public ProductoDTO getProduct(@PathVariable("id") int id) {
        return ProductoDTO.fromModel(productService.getProductById(id).get());
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoDTO create(@RequestBody Product product) {
        return ProductoDTO.fromModel(productService.createProduct(product));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoDTO update(@RequestBody Product product) {
        return ProductoDTO.fromModel(productService.updateProduct(product));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/categoria/{categoria}")
    public List<ProductoDTO> productsByCategory(@PathVariable("categoria") String categoria) {
        return productService.productsByCategory(categoria).stream().map(ProductoDTO::fromModel).collect(Collectors.toList());
    }

    @GetMapping("/precio/{precio}")
    public List<ProductoDTO> productsByPricing(@PathVariable("precio") double precio) {
        return productService.productsByPricing(precio).stream().map(ProductoDTO::fromModel).collect(Collectors.toList());
    }

    @GetMapping("/nombre/{nombre}")
    public List<ProductoDTO> productosxNombre(@PathVariable("nombre") String nombre) {
        return productService.productsByName(nombre).stream().map(ProductoDTO::fromModel).collect(Collectors.toList());
    }

    @GetMapping("/categorias")
    public List<String> categorias() {
        return productService.getAllCategories();
    }
}
