package Reto3_AMFPG.Reto3_AMFPGdemo.Repositorios;

import Reto3_AMFPG.Reto3_AMFPGdemo.Interfaces.InterfaceBarcos;
import Reto3_AMFPG.Reto3_AMFPGdemo.Modelo.Barcos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioBarcos {

    @Autowired
    private InterfaceBarcos crud;

    public List<Barcos> getAll(){
        return (List<Barcos>) crud.findAll();
    }

    public Optional<Barcos> getBarcos(int id){
        return crud.findById(id);
    }

    public Barcos save(Barcos boat){
        return crud.save(boat);
    }
    public void delete(Barcos boat){
        crud.delete(boat);
    }

}
