package Reto3_AMFPG.Reto3_AMFPGdemo.Interfaces;

import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceMensaje extends CrudRepository<Mensaje,Integer> {

}
