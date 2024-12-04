package ucad.sn.gestion_utilisateurs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucad.sn.gestion_utilisateurs.entities.Gerant;

import java.util.List;

@Repository
public interface GerantRepository extends JpaRepository<Gerant, Long> {
}
