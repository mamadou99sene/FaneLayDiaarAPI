package ucad.sn.gestion_utilisateurs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucad.sn.gestion_utilisateurs.entities.Moderateur;
import ucad.sn.gestion_utilisateurs.services.ModerateurService;

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
}
