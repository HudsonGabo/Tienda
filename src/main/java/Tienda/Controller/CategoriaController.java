package Tienda.Controller;

import Tienda.Domain.Categoria;
import Tienda.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String page(Model model) {

        var categorias = categoriaService.getCategorias(false);

        model.addAttribute("categorias", categorias);

        return "/categoria/listado";
    }

    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria) {
        return "/categoria/modificarCategoria";
    }

    @PostMapping("/categoria/guardarCategoria")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/categoria/modificarCategoria/{id_categoria}")
    public String modifica(Categoria categoria, Model model) {
        categoria = categoriaService.getCategorias(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modificarCategoria";
    }

    @GetMapping("categoria/eliminarCategoria/{id_categoria}")
    public String eliminarCategoria(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }

}
