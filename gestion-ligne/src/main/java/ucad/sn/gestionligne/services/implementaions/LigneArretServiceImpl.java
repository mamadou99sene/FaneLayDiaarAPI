package ucad.sn.gestionligne.services.implementaions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ucad.sn.gestionligne.entities.LigneArret;
import ucad.sn.gestionligne.repositories.LigneArretRepository;
import ucad.sn.gestionligne.services.LigneArretService;

@Service
@RequiredArgsConstructor
public class LigneArretServiceImpl implements LigneArretService {
    private final LigneArretRepository ligneArretRepository;

    @Override
    public LigneArret saveLigneArret(LigneArret ligneArret) {
        return ligneArretRepository.save(ligneArret);
    }
}