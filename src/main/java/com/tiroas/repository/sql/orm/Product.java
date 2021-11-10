package com.tiroas.repository.sql.orm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private Integer id;
    private String categoria;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponibilidad = true;
    private int cantidad;
    private String imagen;
}
