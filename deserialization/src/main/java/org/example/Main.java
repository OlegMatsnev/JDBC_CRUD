package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main deerizalization is started");


        String inputPath = "deserialization/src/main/java/org/example/clients.json";

        JsonDeserializer jsonDeserializer = new JsonDeserializer();
        List<Client> clients = jsonDeserializer.deserializeFromJson(inputPath);

        for (Client client : clients) {
            System.out.println(client); // Вывод информации о каждом клиенте в консоль
        }

        System.out.println("Main derizalization is finished");

    }
}