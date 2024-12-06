package ucad.sn.gestionligne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucad.sn.gestionligne.entities.Ligne;
import ucad.sn.gestionligne.entities.LigneArret;

import java.util.List;

@Repository
public interface LigneRepository extends JpaRepository<Ligne,Long> {
    Ligne findByIdModerateur(Long idModerateur);

    @Query("SELECT la FROM LigneArret la WHERE la.ligne.id = :ligneId ORDER BY la.ordreArret")
    List<LigneArret> findLigneArretsByLigneId(Long ligneId);
}
