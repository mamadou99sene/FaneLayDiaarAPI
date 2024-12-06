package ucad.sn.asrservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ASRService {

    // Méthode pour traiter l'audio
    String transcribeAudio(MultipartFile audioFile);



}
