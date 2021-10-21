package Reto3_AMFPG.Reto3_AMFPGdemo.Servicios;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Barcos;
import Reto3_AMFPG.Reto3_AMFPGdemo.Repositorios.RepositorioBarcos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosBarcos {
    @Autowired
    private RepositorioBarcos metodosCrud;

    public List<Barcos> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Barcos> getBarcos(int boatId) {

        return metodosCrud.getBarcos(boatId);
    }

    public Barcos save(Barcos boat) {
        if (boat.getId() == null) {
            return metodosCrud.save(boat);
        } else {
            Optional<Barcos> serbar = metodosCrud.getBarcos(boat.getId());
            if (serbar.isEmpty()) {
                return metodosCrud.save(boat);
            } else {
                return boat;
            }
        }
    }
}
