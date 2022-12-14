package Tienda.Controller;

import Tienda.Domain.Cliente;
import Tienda.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String page(Model model) {

        var clientes = clienteService.getClientes();

        model.addAttribute("clientes", clientes);

        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modificarCliente";
    }

    @PostMapping("/cliente/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificarCliente/{idCliente}")
    public String modifica(Cliente cliente, Model model) {
        cliente = clienteService.getClientes(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificarCliente";
    }

    @GetMapping("cliente/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

}
