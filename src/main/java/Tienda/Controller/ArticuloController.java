package Tienda.Controller;

import Tienda.Domain.Articulo;
import Tienda.Service.ArticuloService;
import Tienda.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticuloController {

    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/articulo/listado")
    public String page(Model model) {

        var articulos = articuloService.getArticulos(false);

        model.addAttribute("articulos", articulos);

        return "/articulo/listado";
    }

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categorias= categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        return "/articulo/modificarArticulo";
    }

    @PostMapping("/articulo/guardarArticulo")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/articulo/modificarArticulo/{id_articulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        var categorias= categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        articulo = articuloService.getArticulos(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificarArticulo";
    }

    @GetMapping("articulo/eliminarArticulo/{id_articulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }

}
