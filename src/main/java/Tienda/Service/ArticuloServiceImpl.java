
package Tienda.Service;

import Tienda.Domain.Articulo;
import Tienda.dao.ArticuloDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService{
@Autowired ArticuloDao articuloDao;
    @Override
    public List<Articulo> getArticulos(boolean activos) {
        var lista =(List<Articulo>)articuloDao.findAll();
        
        if(activos){
            
            lista.removeIf(e ->!e.isActivo());
            
        }
        return lista;
    }

    @Override
    public Articulo getArticulos(Articulo articulo) {
        return articuloDao.findById(articulo.getId_articulo()).orElse(null);
    }

    @Override
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }
    
}
