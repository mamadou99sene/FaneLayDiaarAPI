package ucad.sn.gestionligne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucad.sn.gestionligne.entities.LigneArret;

@Repository
public interface LigneArretRepository extends JpaRepository<LigneArret, Long> {
}
