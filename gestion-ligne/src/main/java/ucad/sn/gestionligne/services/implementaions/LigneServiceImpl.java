package ucad.sn.gestionligne.services.implementaions;

import org.springframework.stereotype.Service;
import ucad.sn.gestionligne.clients.ModerateurRestClient;
import ucad.sn.gestionligne.entities.Ligne;
import ucad.sn.gestionligne.models.Moderateur;
import ucad.sn.gestionligne.repositories.LigneRepository;
import ucad.sn.gestionligne.services.LigneService;
@Service
public class LigneServiceImpl implements LigneService {
    private LigneRepository ligneRepository;
    private ModerateurRestClient restClient;

    public LigneServiceImpl(LigneRepository ligneRepository, ModerateurRestClient restClient) {
        this.ligneRepository = ligneRepository;
        this.restClient = restClient;
    }

    @Override
    public Ligne getLigneByModerateur(Long idModerateur) {
        Ligne ligne = this.ligneRepository.findByIdModerateur(idModerateur);
        Moderateur moderateur = this.restClient.getModerateurById(ligne.getIdModerateur());
        ligne.setModerateur(moderateur);
        return ligne;

    }
}
