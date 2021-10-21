package Reto3_AMFPG.Reto3_AMFPGdemo.Servicios;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Mensaje;
import Reto3_AMFPG.Reto3_AMFPGdemo.Repositorios.RepositorioMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<Mensaje> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    public Mensaje save(Mensaje message) {
        if (message.getIdMessage() == null) {
            return metodosCrud.save(message);
        } else {
            Optional<Mensaje> sermen = metodosCrud.getMessage(message.getIdMessage());
            if (sermen.isEmpty()) {
                return metodosCrud.save(message);
            } else {
                return message;
            }
        }
    }
}
