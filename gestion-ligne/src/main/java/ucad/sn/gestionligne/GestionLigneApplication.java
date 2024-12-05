package ucad.sn.gestionligne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestionLigneApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionLigneApplication.class, args);
    }

}
