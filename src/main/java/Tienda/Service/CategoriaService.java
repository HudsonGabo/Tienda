
package Tienda.Service;

import Tienda.Domain.Categoria;
import java.util.List;


public interface CategoriaService {
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategorias(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
}
