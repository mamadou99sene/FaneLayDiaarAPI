package ucad.sn.gestion_utilisateurs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucad.sn.gestion_utilisateurs.entities.Moderateur;
import ucad.sn.gestion_utilisateurs.services.ModerateurService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModerateurController {
    private ModerateurService moderateurService;

    public ModerateurController(ModerateurService moderateurService) {
        this.moderateurService = moderateurService;
    }
    @GetMapping("/moderateur/{id}")
    ResponseEntity<Moderateur> getModerateurById(@PathVariable Long id)
    {
        Moderateur moderateur = this.moderateurService.getModerateurByid(id);
        return ResponseEntity.status(HttpStatus.OK).body(moderateur);
    }
    @PostMapping("/moderateur")
    ResponseEntity<Moderateur> saveModerateur(@RequestBody Moderateur moderateur)
    {
        Moderateur saved = this.moderateurService.saveModerateur(moderateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping("/moderateursbyGerant/{id}")
    ResponseEntity<List<Moderateur>> getModerateursByIdGerant(@PathVariable Long id)
    {
        List<Moderateur> moderateursByIdGerant = this.moderateurService.getModerateursByIdGerant(id);
        return ResponseEntity.status(HttpStatus.OK).body(moderateursByIdGerant);
    }
}
