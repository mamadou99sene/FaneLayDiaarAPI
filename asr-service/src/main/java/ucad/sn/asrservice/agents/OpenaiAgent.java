package ucad.sn.asrservice.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.Media;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;
import ucad.sn.asrservice.annotations.IaAgent;

import java.io.IOException;
@IaAgent
@Component
public class OpenaiAgent {
    private ChatClient chatClient;

    public OpenaiAgent(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    public String ocrAudioExtractAdress(MultipartFile file) throws IOException {
       return this.chatClient.
                prompt().
                functions("openAiTools").
                call().
                content();
    }


}
