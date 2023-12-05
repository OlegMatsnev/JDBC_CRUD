package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main Serizalization is started");

        ClientGenerator generator = new ClientGenerator();
        JsonSerializer jsonSerializer = new JsonSerializer();
        String outputPath = "deserialization/src/main/java/org/example/clients.json";
        int numberOfClientsToGenerate = 100; // Количество клиентов для генерации

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputPath), StandardCharsets.UTF_8)) {
            writer.write("["); // Открываем массив JSON
            for (int i = 0; i < numberOfClientsToGenerate; i++) {
                Client client = generator.generateClients(); // Создайте и получите первого клиента
                String json = jsonSerializer.serializeToJson(client);
                writer.write(json);

                if (i < numberOfClientsToGenerate - 1) {
                    writer.write(","); // Добавляем запятую между объектами
                }


            }

            writer.write("]"); // Закрываем массив JSON
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Main Serizalization is finished");


    }
}