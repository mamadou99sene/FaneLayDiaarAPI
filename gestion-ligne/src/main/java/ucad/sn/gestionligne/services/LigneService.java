package ucad.sn.gestionligne.services;

import ucad.sn.gestionligne.entities.Arret;
import ucad.sn.gestionligne.entities.Ligne;

import java.util.List;

public interface LigneService {
    Ligne getLigneByModerateur(Long idModerateur);
    Ligne saveLigne(Ligne ligne);
    List<Arret> getArretsByLigneId(Long ligneId);
}
