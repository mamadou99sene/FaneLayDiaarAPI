package ucad.sn.gestionligne;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import ucad.sn.gestionligne.entities.Arret;
import ucad.sn.gestionligne.entities.Ligne;
import ucad.sn.gestionligne.entities.Vehicules;
import ucad.sn.gestionligne.services.ArretService;
import ucad.sn.gestionligne.services.LigneService;
import ucad.sn.gestionligne.services.VehiculeService;

@SpringBootApplication
@EnableFeignClients
public class GestionLigneApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionLigneApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(LigneService ligneService, VehiculeService vehiculeService, ArretService arretService)
    {
        return args -> {
            Ligne ligne = ligneService.saveLigne(Ligne.builder()
                    .depart("Guediawaye")
                    .arrivee("SAHM")
                    .numero(34)
                    .idModerateur(1L)
                    .build());
            vehiculeService.saveVehicules(Vehicules.builder()
                            .ligne(ligne)
                            .immatriculation("TH123")
                    .build());
            arretService.saveArret(Arret.builder()
                            .ligne(ligne)
                            .adresse("ucad")
                    .build());
        };
    }

}
