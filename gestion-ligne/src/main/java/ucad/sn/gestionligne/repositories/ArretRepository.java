package ucad.sn.gestionligne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucad.sn.gestionligne.entities.Arret;
@Repository
public interface ArretRepository extends JpaRepository<Arret, Long> {
}
