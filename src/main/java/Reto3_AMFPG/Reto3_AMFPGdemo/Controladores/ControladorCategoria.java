package Reto3_AMFPG.Reto3_AMFPGdemo.Controladores;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Categoria;
import Reto3_AMFPG.Reto3_AMFPGdemo.Servicios.ServiciosCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Categoria")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorCategoria {
    @Autowired
    private ServiciosCategoria servicio;

    @GetMapping("/todas")
    public List<Categoria> getCategoria() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategoria(@PathVariable("id") int categoriaId) {
        return servicio.getCategoria(categoriaId);
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria) {
        return servicio.save(categoria);
    }
}
