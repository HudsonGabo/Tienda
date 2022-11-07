
package Tienda.dao;

import Tienda.Domain.Articulo;
import org.springframework.data.repository.CrudRepository;


public interface ArticuloDao extends CrudRepository<Articulo, Long>{
    
}
