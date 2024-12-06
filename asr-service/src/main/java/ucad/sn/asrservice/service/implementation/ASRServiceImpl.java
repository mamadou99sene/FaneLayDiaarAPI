package ucad.sn.asrservice.service.implementation;

import com.theokanning.openai.audio.CreateTranscriptionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ucad.sn.asrservice.service.ASRService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ASRServiceImpl implements ASRService {
    private final OpenAiService openAiService;
    private static final String WHISPER_MODEL = "whisper-1";
    private static final List<String> SUPPORTED_FORMATS = Arrays.asList(
            "flac", "m4a", "mp3", "mp4", "mpeg", "mpga", "oga", "ogg", "wav", "webm"
    );

    public ASRServiceImpl(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @Override
    public String transcribeAudio(MultipartFile audioFile) {
        validateAudioFile(audioFile);
        File convertedFile = null;
        try {
            convertedFile = convertMultipartFileToFile(audioFile);
            return performTranscription(convertedFile);
        } catch (IOException e) {
            e.printStackTrace();
            return "Erreur lors de la manipulation du fichier: " + e.getMessage();
        } finally {
            cleanupTempFile(convertedFile);
        }
    }

    private void validateAudioFile(MultipartFile audioFile) {
        if (audioFile == null || audioFile.isEmpty()) {
            throw new IllegalArgumentException("Le fichier audio est vide.");
        }
        String originalFilename = audioFile.getOriginalFilename();
        if (originalFilename == null) {
            throw new IllegalArgumentException("Nom de fichier invalide.");
        }
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
        if (!SUPPORTED_FORMATS.contains(extension)) {
            throw new IllegalArgumentException("Format de fichier non supporté. Formats acceptés : "
                    + String.join(", ", SUPPORTED_FORMATS));
        }
    }

    private File convertMultipartFileToFile(MultipartFile audioFile) throws IOException {
        String extension = audioFile.getOriginalFilename().substring(
                audioFile.getOriginalFilename().lastIndexOf(".") + 1
        );
        File convertedFile = File.createTempFile("audio", "." + extension);
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(audioFile.getBytes());
        }
        return convertedFile;
    }

    private String performTranscription(File audioFile) {
        try {
            CreateTranscriptionRequest request = new CreateTranscriptionRequest();
            request.setModel(WHISPER_MODEL);
            return openAiService.createTranscription(request, audioFile).getText();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la transcription: " + e.getMessage(), e);
        }
    }

    private void cleanupTempFile(File file) {
        if (file != null && file.exists()) {
            file.delete();
        }
    }
}