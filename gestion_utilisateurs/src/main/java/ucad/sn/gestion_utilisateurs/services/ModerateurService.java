package ucad.sn.gestion_utilisateurs.services;

import ucad.sn.gestion_utilisateurs.entities.Gerant;
import ucad.sn.gestion_utilisateurs.entities.Moderateur;

import java.util.List;

public interface ModerateurService {
    List<Moderateur> getModerateursByIdGerant(Long idGerant);
    Moderateur getModerateurByid(Long id);
    Moderateur saveModerateur(Moderateur moderateur);
}
