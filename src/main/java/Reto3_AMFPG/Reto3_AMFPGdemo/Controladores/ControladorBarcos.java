package Reto3_AMFPG.Reto3_AMFPGdemo.Controladores;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Barcos;
import Reto3_AMFPG.Reto3_AMFPGdemo.Servicios.ServiciosBarcos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorBarcos {
    @Autowired
    private ServiciosBarcos servicio;

    @GetMapping("/all")
    public List<Barcos> getBarcos() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Barcos> getBarcos(@PathVariable("id") int boadId) {
        return servicio.getBarcos(boadId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Barcos save(@RequestBody Barcos boat) {
        return servicio.save(boat);
    }
}
