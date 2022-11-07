
package Tienda.dao;


import Tienda.Domain.Credito;
import org.springframework.data.repository.CrudRepository;


public interface CreditoDao extends CrudRepository<Credito, Long> {
    
}
