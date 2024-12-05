package ucad.sn.gestion_utilisateurs.services.implementations;

import org.springframework.stereotype.Service;
import ucad.sn.gestion_utilisateurs.entities.Gerant;
import ucad.sn.gestion_utilisateurs.repositories.GerantRepository;
import ucad.sn.gestion_utilisateurs.services.GerantService;

import java.util.List;
@Service
public class GerantServiceImpl implements GerantService {
    private GerantRepository gerantRepository;

    public GerantServiceImpl(GerantRepository gerantRepository) {
        this.gerantRepository = gerantRepository;
    }

    @Override
    public List<Gerant> getAllGerant() {
        return this.gerantRepository.findAll();
    }

    @Override
    public Gerant saveGerant(Gerant gerant) {
        return this.gerantRepository.save(gerant);
    }
}
