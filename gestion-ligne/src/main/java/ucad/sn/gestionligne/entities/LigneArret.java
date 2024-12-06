package ucad.sn.gestionligne.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LigneArret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ligne_id")
    private Ligne ligne;

    @ManyToOne
    @JoinColumn(name = "arret_id")
    private Arret arret;
    private Integer ordreArret;
}
