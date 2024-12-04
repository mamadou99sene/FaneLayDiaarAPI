package ucad.sn.gestion_utilisateurs.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Moderateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String prenom;
    String nom;
    String email;
    String telephone;
    String password;
    @ManyToOne
    @JoinColumn(name = "gerant_id", nullable = false)
    Gerant gerant;
}
