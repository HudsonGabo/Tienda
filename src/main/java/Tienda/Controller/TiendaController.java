
package Tienda.Controller;

import Tienda.Domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller

public class TiendaController {
    
    @GetMapping("/")
    public String page(Model model) {
        
        log.info("ESTAMOS USANDO UNA ARQUITECTURA MVC");

        Cliente cliente1 = new Cliente("Gabriel", "Hudson", "correo@abc.com", "8888-8888");
        Cliente cliente2 = new Cliente("Gabriela", "Vargas", "abc@correo.com", "7777-7777");
        
        var clientes=Arrays.asList(cliente1,cliente2);
        model.addAttribute("clientes",clientes);
        
        return "index";
    }
    
}
