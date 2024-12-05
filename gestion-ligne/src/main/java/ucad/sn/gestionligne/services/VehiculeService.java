package ucad.sn.gestionligne.services;

import ucad.sn.gestionligne.entities.Vehicules;
import java.util.List;

public interface VehiculeService {
    List<Vehicules> getVehiculesByLigne(Long idLigne);

}