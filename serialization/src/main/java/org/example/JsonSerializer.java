package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonSerializer {

    public String serializeToJson(Client client) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // или выбросить исключение, если необрабатываемая ошибка
    }
}
