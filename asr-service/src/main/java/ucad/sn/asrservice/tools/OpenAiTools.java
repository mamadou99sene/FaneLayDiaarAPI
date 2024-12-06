package ucad.sn.asrservice.tools;

import jdk.jfr.Description;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.Media;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;
import ucad.sn.asrservice.records.Localisation;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
@Service("openAiTools")
@Description("""
        Recupere les informations necessaire au niveau du fichier audio et essaye de retourner:
        -   L'adresse de destination exacte de l'utilisateur
        """)
public class OpenAiTools implements Function<OpenAiTools.Request,OpenAiTools.Response> {
    private ChatClient chatClient;
    private String systemMessage= """
            Vous êtes un assistant virtuel pour faire de la transcription et l'analyse audio.
            Vous allez analyser le fichier audio qui vous est soumis par un utilisateur souhaitant se rendre 
            à une adresse et vous allez ressortir le nom de l'adresse en en chaine de caractere.
            Vous devez tenir compte des langues locales parlé au sénégal comme le wolof
            """;
    private String userMessage="""
        Analyse le fichier audio et donne-moi en texte l'adresse de destination
""";

    public OpenAiTools(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }


    public record Request(MultipartFile file){

    };
    public record Response(Localisation localisation){}
    @Override
    public Response apply(Request request) {
        Resource resource = null;
        try {
            resource = new ByteArrayResource(request.file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MimeType mimeType = MimeTypeUtils.parseMimeType("audio/mpeg");
        SystemMessage systemMessage = new SystemMessage(this.systemMessage);
        UserMessage userMessage = new UserMessage(this.userMessage, List.of(
                new Media(mimeType, resource)
        ));
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        Localisation entity = chatClient.prompt(prompt).call().entity(Localisation.class);
        return new Response(entity);
    }

}
