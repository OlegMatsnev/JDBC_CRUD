package console_utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UpdateUtils {

    public static int getAttributeChoice(Scanner scanner, List<String> attributes) {

        while (true) {

            System.out.println("Enter the number of the attribute to update (enter 0 to exit)");
            String input = scanner.nextLine().trim();

            try {
                int attributeChoice = Integer.parseInt(input);

                if (attributeChoice == 0) {
                    return 0; // Выход из метода, если введен 0
                }

                if (attributeChoice < 0 || attributeChoice >= attributes.size() || attributeChoice == 1) {
                    System.out.println("Invalid attribute number. Please choose a valid attribute.");
                    continue;
                }

                return attributeChoice;
            } catch (NumberFormatException e) {
                System.out.println("Неправильный формат ввода! Введите число");
            }
        }
    }

    public static Map<String, Object> collectUpdateData(Connection connection, Scanner scanner, String tableName) throws SQLException {

        // Получаем id записи, которую будем обновлять
        String recordId = General.getUserInput2(scanner, "Enter the ID of the record to update", null);

        // Выводим информацию о записи
        List<String> attributes = getTableAttributes(connection, tableName);

        Map<String, Object> updateData = new HashMap<>();

        if (tableName.equals("client")) {
            for (int i = 1; i < attributes.size(); i++) {
                String attribute = attributes.get(i);
                System.out.println((i + 1) + ") " + attribute);
            }
        } else {
            for (int i = 1; i < attributes.size() - 1; i++) {
                String attribute = attributes.get(i);
                System.out.println((i + 1) + ") " + attribute);
            }
        }

        int attributeChoice = getAttributeChoice(scanner, attributes);

        if (attributeChoice == 0) {
            return null;
        }

        // Получаем имя выбранного атрибута
        String attributeName = attributes.get(attributeChoice - 1);

        // Получаем новое значение атрибута
        String newValue = General.getUserInput("Enter the new value for the attribute");


        // Добавляем данные в Map
        updateData.put("tableName", tableName);
        updateData.put("recordId", recordId);
        updateData.put("attributeName", attributeName);
        updateData.put("newValue", newValue);


        return updateData;
    }

    private static List<String> getTableAttributes(Connection connection, String tableName) throws SQLException {
        List<String> attributes = new ArrayList<>();
        DatabaseMetaData metadata = connection.getMetaData();
        try (ResultSet resultSet = metadata.getColumns(null, null, tableName, null)) {
            while (resultSet.next()) {
                String attributeName = resultSet.getString("COLUMN_NAME");
                attributes.add(attributeName);
            }
        }
        return attributes;
    }

}
