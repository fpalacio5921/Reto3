package Reto3_AMFPG.Reto3_AMFPGdemo.Controladores;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Cliente;
import Reto3_AMFPG.Reto3_AMFPGdemo.Servicios.ServiciosCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cliente")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorCliente {
    @Autowired
    private ServiciosCliente servicio;

    @GetMapping("/todas")
    public List<Cliente> getClients() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getClient(@PathVariable("id") int clientId) {
        return servicio.getClient(clientId);
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente client) {
        return servicio.save(client);
    }
}
