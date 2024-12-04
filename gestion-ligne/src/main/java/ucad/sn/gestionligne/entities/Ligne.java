package ucad.sn.gestionligne.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ucad.sn.gestionligne.models.Moderateur;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String depart;
    String arrivee;
    int numero;
    Long idModerateur;
    @Transient
    Moderateur moderateur;
}
