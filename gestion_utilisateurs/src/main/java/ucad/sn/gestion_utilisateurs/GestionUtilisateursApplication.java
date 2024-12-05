package ucad.sn.gestion_utilisateurs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
            moderateurService.saveModerateur(Moderateur.builder()
                    .email("saliou@gmail.com")
                    .telephone("771230909")
                    .nom("Ly")
                    .prenom("Saliou")
                    .password("123")
                    .gerant(gerant)
                    .build());

        };
    }

}
