package Reto3_AMFPG.Reto3_AMFPGdemo.Servicios;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Reservaciones;
import Reto3_AMFPG.Reto3_AMFPGdemo.Repositorios.RepositorioReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosReservaciones {
    @Autowired
    private RepositorioReservaciones metodosCrud;

    public List<Reservaciones> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reservaciones save(Reservaciones reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservaciones> serreser = metodosCrud.getReservation(reservation.getIdReservation());
            if (serreser.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }
}
