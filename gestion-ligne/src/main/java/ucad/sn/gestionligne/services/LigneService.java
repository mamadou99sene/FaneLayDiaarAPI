package ucad.sn.gestionligne.services;

import ucad.sn.gestionligne.entities.Ligne;

public interface LigneService {
    Ligne getLigneByModerateur(Long idModerateur);
    Ligne saveLigne(Ligne ligne);
}
