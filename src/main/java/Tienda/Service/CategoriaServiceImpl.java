
package Tienda.Service;

import Tienda.Domain.Categoria;
import Tienda.dao.CategoriaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
@Autowired CategoriaDao categoriaDao;
    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista =(List<Categoria>)categoriaDao.findAll();
        
        if(activos){
            
            lista.removeIf(e ->!e.isActivo());
            
        }
        return lista;
    }

    @Override
    public Categoria getCategorias(Categoria categoria) {
        return categoriaDao.findById(categoria.getId_categoria()).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}
