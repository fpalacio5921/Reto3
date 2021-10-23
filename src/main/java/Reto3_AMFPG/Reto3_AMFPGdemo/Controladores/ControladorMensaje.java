package Reto3_AMFPG.Reto3_AMFPGdemo.Controladores;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Mensaje;
import Reto3_AMFPG.Reto3_AMFPGdemo.Servicios.ServiciosMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorMensaje {
    @Autowired
    private ServiciosMensaje servico;

    @GetMapping("/all")
    public List<Mensaje> getMessages() {
        return servico.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mensaje> getMessage(@PathVariable("id") int messageId) {
        return servico.getMessage(messageId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje message) {
        return servico.save(message);
    }
}
