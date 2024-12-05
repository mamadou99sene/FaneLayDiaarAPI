package ucad.sn.gestionligne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucad.sn.gestionligne.entities.Ligne;
@Repository
public interface LigneRepository extends JpaRepository<Ligne,Long> {
    Ligne findByIdModerateur(Long idModerateur);
}
