package ucad.sn.gestionligne.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

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
//    @ManyToOne
//    @JoinColumn(name = "ligne_id", nullable = false)
//    Ligne ligne;
      @JsonIgnore
      @OneToMany(mappedBy = "arret")
      private List<LigneArret> ligneArrets;
}
