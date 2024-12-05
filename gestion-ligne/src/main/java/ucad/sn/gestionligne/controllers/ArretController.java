package ucad.sn.gestionligne.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucad.sn.gestionligne.entities.Arret;
import ucad.sn.gestionligne.entities.Ligne;
import ucad.sn.gestionligne.entities.Vehicules;
import ucad.sn.gestionligne.services.ArretService;
import ucad.sn.gestionligne.services.LigneService;
import ucad.sn.gestionligne.services.VehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/ligne")
public class ArretController {
    private final ArretService arretService;
    private final LigneService ligneService;
    private final VehiculeService vehiculeService;

    public ArretController(
            ArretService arretService,
            LigneService ligneService,
            VehiculeService vehiculeService
    ) {
        this.arretService = arretService;
        this.ligneService = ligneService;
        this.vehiculeService = vehiculeService;
    }

    // Opérations pour Ligne
    @GetMapping("/moderateur/{idModerateur}")
    public ResponseEntity<Ligne> getLigneByModerateur(@PathVariable Long idModerateur) {
        Ligne ligne = ligneService.getLigneByModerateur(idModerateur);
        return ResponseEntity.ok(ligne);
    }

    // Opérations pour Arret
    @GetMapping("/arrets/ligne/{idLigne}")
    public ResponseEntity<List<Arret>> getArretsByLigne(@PathVariable Long idLigne) {
        List<Arret> arrets = arretService.getArretsByLigne(idLigne);
        return ResponseEntity.ok(arrets);
    }

    // Opérations pour Vehicules
    @GetMapping("/vehicules/ligne/{idLigne}")
    public ResponseEntity<List<Vehicules>> getVehiculesByLigne(@PathVariable Long idLigne) {
        List<Vehicules> vehicules = vehiculeService.getVehiculesByLigne(idLigne);
        return ResponseEntity.ok(vehicules);

    }


}