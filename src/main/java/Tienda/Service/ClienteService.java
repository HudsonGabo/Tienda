
package Tienda.Service;

import Tienda.Domain.Cliente;
import java.util.List;

public interface ClienteService {
    
    public List<Cliente> getClientes();
    
    public Cliente getClientes(Cliente cliente);
    
    public void save(Cliente cliente);
    
    public void delete(Cliente cliente);
}
