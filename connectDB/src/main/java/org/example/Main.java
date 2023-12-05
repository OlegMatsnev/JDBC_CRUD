package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        DatabaseInitializer.createTables();
        DatabasePopulator.fillTables();

    }
}