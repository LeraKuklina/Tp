package org.example;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Успешно подключились к бд!");
            } else {
                System.out.println("Не подключились!");
            }
        } catch (SQLException e) {
            System.out.println("ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
