package CRUD;

import java.sql.*;

public class Update {


    public static void updateRecordAttribute(Connection connection, String tableName, String recordId,
                                              String attributeName, Object newValue) throws SQLException {


        String updateQuery = "UPDATE " + tableName + " SET " + attributeName + " = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setObject(1, newValue);
            preparedStatement.setString(2, recordId);
            preparedStatement.executeUpdate();
            System.out.println("Record attribute updated successfully.");
        }
    }
}
