package ucad.sn.gestionligne.services;

import ucad.sn.gestionligne.entities.Arret;
import ucad.sn.gestionligne.entities.Ligne;

import java.util.List;

public interface ArretService {
    List<Arret> getArretsByLigne(Long idLigne);
    Arret saveArret(Arret arret);
    List<Ligne> getLignesByArret(Long arretId);
}