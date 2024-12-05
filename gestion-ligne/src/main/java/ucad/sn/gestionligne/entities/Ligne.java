package ucad.sn.gestionligne.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ucad.sn.gestionligne.models.Moderateur;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String depart;
    String arrivee;
    int numero;
    Long idModerateur;
    @Transient
    Moderateur moderateur;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Transient
    @OneToMany(mappedBy = "ligne", cascade = CascadeType.ALL)
    List<Vehicules> vehicules;
}
