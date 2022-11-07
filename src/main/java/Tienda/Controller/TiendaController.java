
package Tienda.Controller;

import Tienda.Domain.Articulo;
import Tienda.Service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller

public class TiendaController {

        
    @Autowired
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String page(Model model) {
        
     
        var articulos=articuloService.getArticulos(true);        
        
        model.addAttribute("articulos",articulos);
        
        return "index";
    }
    
    
}
