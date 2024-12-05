package ucad.sn.gestionligne.models;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Builder @Getter @Setter
public class Moderateur {
    Long id;
    String prenom;
    String nom;
    String email;
    String telephone;
}
