package ucad.sn.gestion_utilisateurs.services.implementations;

import org.springframework.stereotype.Service;
import ucad.sn.gestion_utilisateurs.entities.Gerant;
import ucad.sn.gestion_utilisateurs.entities.Moderateur;
import ucad.sn.gestion_utilisateurs.repositories.ModerateurRepository;
import ucad.sn.gestion_utilisateurs.services.ModerateurService;

import java.util.List;
import java.util.Optional;

@Service
public class ModerateurServiceImpl implements ModerateurService {
    private ModerateurRepository moderateurRepository;

    public ModerateurServiceImpl(ModerateurRepository moderateurRepository) {
        this.moderateurRepository = moderateurRepository;
    }

    @Override
    public List<Moderateur> getModerateursByIdGerant(Gerant gerant) {
        List<Moderateur> moderateurs = this.moderateurRepository.findByGerant(gerant);
        return moderateurs;
    }

    @Override
    public Moderateur getModerateurByid(Long id) {
        Optional<Moderateur> optional = this.moderateurRepository.findById(id);
        if (optional.isPresent())
        {
            Moderateur moderateur=optional.get();
            return moderateur;
        }
        throw new RuntimeException("Le moderateur n'existe pas");
    }
}
