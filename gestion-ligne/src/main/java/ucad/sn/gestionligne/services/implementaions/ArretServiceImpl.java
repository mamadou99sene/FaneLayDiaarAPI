package ucad.sn.gestionligne.services.implementations;

import org.springframework.stereotype.Service;
import ucad.sn.gestionligne.entities.Ligne;
import ucad.sn.gestionligne.repositories.ArretRepository;
import ucad.sn.gestionligne.repositories.LigneRepository;
import ucad.sn.gestionligne.services.ArretService;
import ucad.sn.gestionligne.entities.Arret;
import java.util.List;
import java.util.Optional;

@Service
public class ArretServiceImpl implements ArretService {
    private final ArretRepository arretRepository;
    private final LigneRepository ligneRepository;

    public ArretServiceImpl(ArretRepository arretRepository, LigneRepository ligneRepository) {
        this.arretRepository = arretRepository;
        this.ligneRepository = ligneRepository;
    }

    @Override
    public List<Arret> getArretsByLigne(Long idLigne) {
        Optional<Ligne> optionalLigne = this.ligneRepository.findById(idLigne);
        if (optionalLigne.isPresent())
        {
            Ligne ligne = optionalLigne.get();
            return this.arretRepository.findByLigne(ligne);
        }
        throw new RuntimeException("Cet identifiant de ligne n'existe pas");
    }

    @Override
    public Arret saveArret(Arret arret) {
        return this.arretRepository.save(arret);
    }
}