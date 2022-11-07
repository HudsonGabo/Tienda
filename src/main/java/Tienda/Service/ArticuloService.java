
package Tienda.Service;

import Tienda.Domain.Articulo;
import java.util.List;


public interface ArticuloService {
     public List<Articulo> getArticulos(boolean activos);
    
    public Articulo getArticulos(Articulo articulo);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
}
