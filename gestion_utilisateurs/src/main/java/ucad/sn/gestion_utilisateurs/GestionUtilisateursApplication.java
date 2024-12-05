package ucad.sn.gestion_utilisateurs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ucad.sn.gestion_utilisateurs.entities.Gerant;
import ucad.sn.gestion_utilisateurs.entities.Moderateur;
import ucad.sn.gestion_utilisateurs.services.GerantService;
import ucad.sn.gestion_utilisateurs.services.ModerateurService;

@SpringBootApplication
public class GestionUtilisateursApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionUtilisateursApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(GerantService gerantService, ModerateurService moderateurService)
    {
        return args -> {
            Gerant gerant = Gerant.builder()
                    .email("aftu@gmail.com")
                    .nom("AFTU")
                    .telephone("777898800")
                    .password("aftu123")
                    .build();
            gerantService.saveGerant(gerant);
            moderateurService.saveModerateur(Moderateur.builder()
                            .email("modou@gmail.com")
                            .telephone("771230909")
                            .nom("Faye")
                            .prenom("Modou")
                            .password("123")
                            .gerant(gerant)
                    .build());

        };
    }

}
