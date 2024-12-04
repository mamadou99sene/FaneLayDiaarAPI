package ucad.sn.gestionligne.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String depart;
    String arrivee;
    int numero;
}
