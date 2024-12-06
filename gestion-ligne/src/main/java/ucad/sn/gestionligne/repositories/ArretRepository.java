package ucad.sn.gestionligne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucad.sn.gestionligne.entities.Arret;
import ucad.sn.gestionligne.entities.Ligne;
import ucad.sn.gestionligne.entities.LigneArret;

import java.util.List;

@Repository
public interface ArretRepository extends JpaRepository<Arret, Long> {
    //List<Arret> findByLigne(Ligne ligne);

    @Query("SELECT a FROM Arret a JOIN LigneArret la ON a.id = la.arret.id WHERE la.ligne = :ligne")
    List<Arret> findByLigneArret(@Param("ligne") Ligne ligne);
    @Query("SELECT la FROM LigneArret la WHERE la.arret.id = :arretId ORDER BY la.ordreArret")
    List<LigneArret> findLigneArretsByArretId(Long arretId);
}