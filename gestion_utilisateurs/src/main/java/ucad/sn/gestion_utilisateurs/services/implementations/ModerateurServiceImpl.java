package ucad.sn.gestion_utilisateurs.services.implementations;

import org.springframework.stereotype.Service;
import ucad.sn.gestion_utilisateurs.entities.Gerant;
import ucad.sn.gestion_utilisateurs.entities.Moderateur;
import ucad.sn.gestion_utilisateurs.repositories.GerantRepository;
import ucad.sn.gestion_utilisateurs.repositories.ModerateurRepository;
import ucad.sn.gestion_utilisateurs.services.ModerateurService;

import java.util.List;
import java.util.Optional;

@Service
public class ModerateurServiceImpl implements ModerateurService {
    private ModerateurRepository moderateurRepository;
    private GerantRepository gerantRepository;

    public ModerateurServiceImpl(ModerateurRepository moderateurRepository, GerantRepository gerantRepository) {
        this.moderateurRepository = moderateurRepository;
        this.gerantRepository = gerantRepository;
    }

    @Override
    public List<Moderateur> getModerateursByIdGerant(Long idGerant) {
        Optional<Gerant> optionalGerant = this.gerantRepository.findById(idGerant);
        if (optionalGerant.isPresent())
        {
            Gerant gerant=optionalGerant.get();
            List<Moderateur> moderateurs = this.moderateurRepository.findByGerant(gerant);
            return moderateurs;
        }
        else
            throw new RuntimeException("Ce gerant est introuvable");

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

    @Override
    public Moderateur saveModerateur(Moderateur moderateur) {
       return this.moderateurRepository.save(moderateur);
    }
}
