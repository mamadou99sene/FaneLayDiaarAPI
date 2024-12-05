package ucad.sn.gestionligne.services.implementations;

import org.springframework.stereotype.Service;
import ucad.sn.gestionligne.repositories.ArretRepository;
import ucad.sn.gestionligne.services.ArretService;
import ucad.sn.gestionligne.entities.Arret;
import java.util.List;

@Service
public class ArretServiceImpl implements ArretService {
    private final ArretRepository arretRepository;

    public ArretServiceImpl(ArretRepository arretRepository) {
        this.arretRepository = arretRepository;
    }

    @Override
    public List<Arret> getArretsByLigne(Long idLigne) {
        return arretRepository.findByLigneId(idLigne);
        //modou
    }
}