package service;

import dto.DestinationRequest;
import dto.DestinationResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ASRService {

    // Méthode pour traiter l'audio
    String transcribeAudio(MultipartFile audioFile);


}
