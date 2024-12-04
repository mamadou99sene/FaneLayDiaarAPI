package ucad.sn.gestionligne.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ucad.sn.gestionligne.models.Moderateur;

@FeignClient("localhost:8081")
public interface ModerateurRestClient{
    @GetMapping("/api/moderateur/{id}")
    Moderateur getModerateurById(@PathVariable Long id);
}
