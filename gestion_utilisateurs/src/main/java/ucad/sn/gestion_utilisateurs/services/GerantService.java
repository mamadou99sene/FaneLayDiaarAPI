package ucad.sn.gestion_utilisateurs.services;

import ucad.sn.gestion_utilisateurs.entities.Gerant;

import java.util.List;

public interface GerantService {
    List<Gerant> getAllGerant();
    Gerant saveGerant(Gerant gerant);
}
