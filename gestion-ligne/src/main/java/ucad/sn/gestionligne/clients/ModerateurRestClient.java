package ucad.sn.gestionligne.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ucad.sn.gestionligne.models.Moderateur;

@FeignClient(name = "moderateur-service", url = "http://localhost:8081")
public interface ModerateurRestClient{
    @GetMapping("/api/utilisateurs/moderateur/{id}")
    Moderateur getModerateurById(@PathVariable Long id);
}
