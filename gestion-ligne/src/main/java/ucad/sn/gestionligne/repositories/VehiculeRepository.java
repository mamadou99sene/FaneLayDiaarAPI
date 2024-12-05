package ucad.sn.gestionligne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucad.sn.gestionligne.entities.Vehicules;
import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicules, Long> {
    List<Vehicules> findByLigneId(Long ligneId);
}