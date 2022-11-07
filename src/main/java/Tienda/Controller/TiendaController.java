
package Tienda.Controller;

import Tienda.Service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller

public class TiendaController {

        
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String page(Model model) {
        
        log.info("ESTAMOS USANDO UNA ARQUITECTURA MVC");

        
        var clientes=clienteService.getClientes();
        
        model.addAttribute("clientes",clientes);
        
        return "index";
    }
    
}
