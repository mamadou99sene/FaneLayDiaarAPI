package ucad.sn.gestionligne.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Arret {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String adresse;
    @ManyToOne
    @JoinColumn(name = "ligne_id", nullable = false)
    Ligne ligne;
}
