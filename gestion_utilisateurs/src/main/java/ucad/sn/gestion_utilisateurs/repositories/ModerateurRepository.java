package ucad.sn.gestion_utilisateurs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucad.sn.gestion_utilisateurs.entities.Gerant;
import ucad.sn.gestion_utilisateurs.entities.Moderateur;

import java.util.List;

@Repository
public interface ModerateurRepository extends JpaRepository<Moderateur, Long> {
    List<Moderateur> findByGerant(Gerant gerant);
}
