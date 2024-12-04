package ucad.sn.gestion_utilisateurs.services.implementations;

import org.springframework.stereotype.Service;
import ucad.sn.gestion_utilisateurs.entities.Moderateur;
import ucad.sn.gestion_utilisateurs.repositories.ModerateurRepository;
import ucad.sn.gestion_utilisateurs.services.ModerateurService;

import java.util.List;
@Service
public class ModerateurServiceImpl implements ModerateurService {
    private ModerateurRepository moderateurRepository;

    public ModerateurServiceImpl(ModerateurRepository moderateurRepository) {
        this.moderateurRepository = moderateurRepository;
    }

    @Override
    public List<Moderateur> getModerateursByIdGerant(Long idGerant) {
        List<Moderateur> moderateurs = this.moderateurRepository.getModerateursByGerant(idGerant);
        return moderateurs;
    }
}
