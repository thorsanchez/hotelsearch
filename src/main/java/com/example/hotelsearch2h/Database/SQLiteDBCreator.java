package com.example.hotelsearch2h.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteDBCreator {
    public static void CreateDatabaseIfNotExist() {
        String dbFilePath = "hotel.db";
        String sqlScriptFilePath = "database.sql";

        try {
            // Check if database file exists, we
            // have to create it if not
            File dbFile = new File(dbFilePath);

            if (!dbFile.exists()) {
                dbFile.createNewFile();
            } else
                return;

            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbFilePath);
            Statement statement = connection.createStatement();

            // Read SQL script from file
            BufferedReader reader = new BufferedReader(new FileReader(sqlScriptFilePath));
            StringBuilder sqlScriptBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sqlScriptBuilder.append(line);
                sqlScriptBuilder.append("\n");
            }
            reader.close();

            // Split script into separate statements
            String[] sqlStatements = sqlScriptBuilder.toString().split(";");

            // Execute each statement
            for (String sqlStatement : sqlStatements) {
                if (!sqlStatement.trim().isEmpty()) {
                    statement.executeUpdate(sqlStatement);
                }
            }

            // Close resources
            statement.close();
            connection.close();

            System.out.println("Database created successfully.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
