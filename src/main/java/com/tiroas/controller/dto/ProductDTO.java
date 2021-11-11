package com.tiroas.controller.dto;

import com.tiroas.repository.sql.orm.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO implements Serializable {

    private Integer id;
    private String categoria;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponibilidad = true;
    private int cantidad;
    private String imagen;

    public Product toModel() {
        return new Product(
                this.id,
                this.categoria,
                this.nombre,
                this.descripcion,
                this.precio,
                this.disponibilidad,
                this.cantidad,
                this.imagen);
    }

    public static ProductDTO fromModel(Product product) {
        return new ProductDTO(
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
