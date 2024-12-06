package ucad.sn.gestionligne;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import ucad.sn.gestionligne.entities.Arret;
import ucad.sn.gestionligne.entities.Ligne;
import ucad.sn.gestionligne.entities.LigneArret;
import ucad.sn.gestionligne.entities.Vehicules;
import ucad.sn.gestionligne.services.ArretService;
import ucad.sn.gestionligne.services.LigneArretService;
import ucad.sn.gestionligne.services.LigneService;
import ucad.sn.gestionligne.services.VehiculeService;

@SpringBootApplication
@EnableFeignClients
public class GestionLigneApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionLigneApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(
            LigneService ligneService,
            VehiculeService vehiculeService,
            ArretService arretService,
            LigneArretService ligneArretService) {
        return args -> {
            // Créer les lignes
            Ligne ligne1 = ligneService.saveLigne(Ligne.builder()
                    .depart("Guediawaye")
                    .arrivee("Petersen")
                    .numero(34)
                    .idModerateur(1L)
                    .build());

            Ligne ligne2 = ligneService.saveLigne(Ligne.builder()
                    .depart("Parcelles")
                    .arrivee("Fann")
                    .numero(13)
                    .idModerateur(2L)
                    .build());

            Ligne ligne3 = ligneService.saveLigne(Ligne.builder()
                    .depart("Ouakam")
                    .arrivee("Medina")
                    .numero(7)
                    .idModerateur(1L)
                    .build());

            // Créer les arrêts
            Arret grandYoff = arretService.saveArret(Arret.builder()
                    .adresse("Grand Yoff")
                    .build());

            Arret fann = arretService.saveArret(Arret.builder()
                    .adresse("Fann UCAD")
                    .build());

            Arret medina = arretService.saveArret(Arret.builder()
                    .adresse("Medina")
                    .build());

            Arret colobane = arretService.saveArret(Arret.builder()
                    .adresse("Colobane")
                    .build());

            // Ligne 1: Guediawaye -> Grand Yoff -> Medina -> Colobane -> Petersen
            ligneArretService.saveLigneArret(LigneArret.builder()
                    .ligne(ligne1)
                    .arret(grandYoff)
                    .ordreArret(1)
                    .build());

            ligneArretService.saveLigneArret(LigneArret.builder()
                    .ligne(ligne1)
                    .arret(medina)
                    .ordreArret(2)
                    .build());

            ligneArretService.saveLigneArret(LigneArret.builder()
                    .ligne(ligne1)
                    .arret(colobane)
                    .ordreArret(3)

                    .build());

            // Ligne 2: Parcelles -> Grand Yoff -> Fann UCAD -> Medina
            ligneArretService.saveLigneArret(LigneArret.builder()
                    .ligne(ligne2)
                    .arret(grandYoff)  // Arrêt partagé avec ligne 1
                    .ordreArret(1)
                    .build());

            ligneArretService.saveLigneArret(LigneArret.builder()
                    .ligne(ligne2)
                    .arret(fann)
                    .ordreArret(2)
                    .build());

            ligneArretService.saveLigneArret(LigneArret.builder()
                    .ligne(ligne2)
                    .arret(medina)  // Arrêt partagé avec ligne 1
                    .ordreArret(3)
                    .build());

            // Ligne 3: Ouakam -> Fann UCAD -> Medina -> Colobane
            ligneArretService.saveLigneArret(LigneArret.builder()
                    .ligne(ligne3)
                    .arret(fann)  // Arrêt partagé avec ligne 2
                    .ordreArret(1)
                    .build());

            ligneArretService.saveLigneArret(LigneArret.builder()
                    .ligne(ligne3)
                    .arret(medina)  // Arrêt partagé avec lignes 1 et 2
                    .ordreArret(2)
                    .build());

            ligneArretService.saveLigneArret(LigneArret.builder()
                    .ligne(ligne3)
                    .arret(colobane)  // Arrêt partagé avec ligne 1
                    .ordreArret(3)
                    .build());

            // Ajouter des véhicules
            vehiculeService.saveVehicules(Vehicules.builder()
                    .ligne(ligne1)
                    .immatriculation("DK-1234")
                    .build());

            vehiculeService.saveVehicules(Vehicules.builder()
                    .ligne(ligne2)
                    .immatriculation("DK-5678")
                    .build());

            vehiculeService.saveVehicules(Vehicules.builder()
                    .ligne(ligne3)
                    .immatriculation("DK-9012")
                    .build());
        };
    }

}
