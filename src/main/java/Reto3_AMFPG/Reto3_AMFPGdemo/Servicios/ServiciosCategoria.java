package Reto3_AMFPG.Reto3_AMFPGdemo.Servicios;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Categoria;
import Reto3_AMFPG.Reto3_AMFPGdemo.Repositorios.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;

    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }

    public Categoria save(Categoria categoria) {
        if (categoria.getId() == null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> sercat = metodosCrud.getCategoria(categoria.getId());
            if (sercat.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }
}
