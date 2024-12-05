package ucad.sn.gestionligne.services.implementations;

import org.springframework.stereotype.Service;
import ucad.sn.gestionligne.entities.Ligne;
import ucad.sn.gestionligne.repositories.LigneRepository;
import ucad.sn.gestionligne.repositories.VehiculeRepository;
import ucad.sn.gestionligne.services.VehiculeService;
import ucad.sn.gestionligne.entities.Vehicules;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculeServiceImpl implements VehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final LigneRepository ligneRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository, LigneRepository ligneRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.ligneRepository = ligneRepository;
    }

    @Override
    public List<Vehicules> getVehiculesByLigne(Long idLigne) {
        Optional<Ligne> optionalLigne = this.ligneRepository.findById(idLigne);
        if(optionalLigne.isPresent())
        {
            Ligne ligne=optionalLigne.get();
            List<Vehicules> vehicules = this.vehiculeRepository.findByLigne(ligne);
            return vehicules;
        }
        else
            throw new RuntimeException("identifiant introuvable");
        //modou
    }

    @Override
    public Vehicules saveVehicules(Vehicules vehicules) {
        return this.vehiculeRepository.save(vehicules);
    }
}