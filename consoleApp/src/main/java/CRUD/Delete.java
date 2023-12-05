package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete{
    
    public static void deleteRow(Connection connection, String tableName, String recordId) {
            try {
                // Формируем запрос на удаление записи
                String deleteQuery = "DELETE FROM " + tableName + " WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setString(1, recordId);

                    // Выполняем запрос
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Record deleted successfully.");
                    } else {
                        System.out.println("No records found with the specified ID.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error deleting record: " + e.getMessage());
            }
    }
}

