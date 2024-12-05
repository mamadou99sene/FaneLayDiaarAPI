package ucad.sn.gestion_utilisateurs.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor @AllArgsConstructor @Setter @Getter @Builder
public class Gerant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String email;
    String telephone;
    String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Transient
    @OneToMany(mappedBy = "gerant", cascade = CascadeType.ALL)
    List<Moderateur> moderateurs;
}
