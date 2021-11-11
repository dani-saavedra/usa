/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiroas.controller;

import com.tiroas.controller.dto.ProductDTO;
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
    public ProductDTO getProduct(@PathVariable("id") int id) {
        return ProductDTO.fromModel(productService.getProductById(id).get());
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductDTO product) {
        return ProductDTO.fromModel(productService.createProduct(product.toModel()));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO update(@RequestBody ProductDTO product) {
        return ProductDTO.fromModel(productService.updateProduct(product.toModel()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/categoria/{categoria}")
    public List<ProductDTO> productsByCategory(@PathVariable("categoria") String categoria) {
        return productService.productsByCategory(categoria).stream().map(ProductDTO::fromModel).collect(Collectors.toList());
    }

    @GetMapping("/precio/{precio}")
    public List<ProductDTO> productsByPricing(@PathVariable("precio") double precio) {
        return productService.productsByPricing(precio).stream().map(ProductDTO::fromModel).collect(Collectors.toList());
    }

    @GetMapping("/nombre/{nombre}")
    public List<ProductDTO> productosxNombre(@PathVariable("nombre") String nombre) {
        return productService.productsByName(nombre).stream().map(ProductDTO::fromModel).collect(Collectors.toList());
    }

    @GetMapping("/categorias")
    @ResponseBody
    public List<String> categorias() {
        return productService.getAllCategories();
    }
}
