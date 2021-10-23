package Reto3_AMFPG.Reto3_AMFPGdemo.Controladores;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Reservaciones;
import Reto3_AMFPG.Reto3_AMFPGdemo.Servicios.ServiciosReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorReservaciones {
    @Autowired
    private ServiciosReservaciones servicio;

    @GetMapping("/all")
    public List<Reservaciones> getReservations() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservaciones> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        return servicio.save(reservation);
    }
}