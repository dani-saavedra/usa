package com.tiroas.controller.dto;

import com.tiroas.repository.sql.orm.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Integer id;
    private String categoria;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponibilidad = true;
    private int cantidad;
    private String imagen;

    public static ProductoDTO fromModel(Product product) {
        return new ProductoDTO(
                product.getId(),
                product.getCategoria(),
                product.getNombre(),
                product.getDescripcion(),
                product.getPrecio(),
                product.isDisponibilidad(),
                product.getCantidad(),
                product.getImagen());
    }
}
