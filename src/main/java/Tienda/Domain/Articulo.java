
package Tienda.Domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articulo")

public class Articulo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_articulo;
    private Long id_categoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private boolean activo;

    public Articulo() {
    }

    public Articulo(Long id_categoria, String descripcion, String detalle, double precio, int existencias, boolean activo) {
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }

    
    
    
}
