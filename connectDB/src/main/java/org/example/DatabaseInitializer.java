package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.stream.Collectors;

public class DatabaseInitializer {

    public static void createTables() {
        initializeDatabase();
    }

    private static void initializeDatabase() {
        String[] scriptFiles = {
                "create_client_table.sql",
                "create_account_table.sql",
                "create_bankcard_table.sql",
                "create_credit_table.sql",
                "create_deposit_table.sql",
                "create_transactionhistory_table.sql"
        };

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            for (String scriptFile : scriptFiles) {
                String scriptContent = readScript(scriptFile);
                statement.execute(scriptContent);
                System.out.println("Table created successfully: " + scriptFile);
            }

            System.out.println("All tables created successfully!");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static String readScript(String scriptFileName) throws IOException {
        Path scriptPath = Path.of("C:\\Users\\79158\\IdeaProjects\\TestKotlin\\connectDB\\src\\main\\sqlScripts\\", scriptFileName);
        return Files.lines(scriptPath).collect(Collectors.joining(" "));
    }

    public static Connection getConnection() throws SQLException {
        FileInputStream fis;
        Properties properties = new Properties();

        String url;
        String user;
        String password;


        try {
            fis = new FileInputStream("C:\\Users\\79158\\IdeaProjects\\TestKotlin\\connectDB\\src\\main\\resources\\config.properties");
            properties.load(fis);

             url = properties.getProperty("db_host");
             user = properties.getProperty("name");
             password = properties.getProperty("psw");



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return DriverManager.getConnection(url, user, password);
    }
}
