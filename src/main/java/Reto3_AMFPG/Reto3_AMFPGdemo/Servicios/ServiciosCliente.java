package Reto3_AMFPG.Reto3_AMFPGdemo.Servicios;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Cliente;
import Reto3_AMFPG.Reto3_AMFPGdemo.Repositorios.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosCliente {
    @Autowired
    private RepositorioCliente metodosCrud;

    public List<Cliente> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    public Cliente save(Cliente client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Cliente> sercli = metodosCrud.getCliente(client.getIdClient());
            if (sercli.isEmpty()) {
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }
}