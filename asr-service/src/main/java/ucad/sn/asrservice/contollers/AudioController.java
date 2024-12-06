package ucad.sn.asrservice.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ucad.sn.asrservice.agents.OpenaiAgent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/audio")
@CrossOrigin("*")
public class AudioController {

    private final OpenaiAgent openaiAgent;

    public AudioController(OpenaiAgent openaiAgent) {
        this.openaiAgent = openaiAgent;
    }

    @PostMapping("/extract-address")
    public ResponseEntity<?> extractAddressFromAudio(@RequestParam("file") MultipartFile file) {
        try {
            // Vérifier si le fichier est vide
            if (file.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Le fichier audio est vide");
            }

            // Vérifier le type MIME du fichier
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("audio/")) {
                return ResponseEntity.badRequest()
                        .body("Le fichier doit être un fichier audio valide");
            }

            // Appeler l'agent OpenAI pour extraire l'adresse
            String extractedAddress = openaiAgent.ocrAudioExtractAdress(file);

            // Créer l'objet de réponse
            Map<String, String> response = new HashMap<>();
            response.put("address", extractedAddress);

            return ResponseEntity.ok(response);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors du traitement du fichier audio: " + e.getMessage());
        }
    }
}
