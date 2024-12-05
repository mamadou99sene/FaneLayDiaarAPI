package ucad.sn.gestionligne.services.implementations;

import org.springframework.stereotype.Service;
import ucad.sn.gestionligne.repositories.VehiculeRepository;
import ucad.sn.gestionligne.services.VehiculeService;
import ucad.sn.gestionligne.entities.Vehicules;
import java.util.List;

@Service
public class VehiculeServiceImpl implements VehiculeService {
    private final VehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public List<Vehicules> getVehiculesByLigne(Long idLigne) {
        return vehiculeRepository.findByLigneId(idLigne);
        //modou
    }
}