package Tienda.Service;

import Tienda.Domain.Cliente;
import Tienda.Domain.Credito;
import Tienda.dao.ClienteDao;
import Tienda.dao.CreditoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        var clientes = (List<Cliente>) clienteDao.findAll();
        return clientes;
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente getClientes(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);

    }

    @Transactional
    @Override
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        
        credito= creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        Credito credito = cliente.getCredito();
        clienteDao.delete(cliente);
    }

}
