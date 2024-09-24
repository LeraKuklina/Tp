package org.example;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Statement;

public class TableCreator {

    public static void createTable(Class<?> clazz, Connection connection) throws Exception {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("Класс " + clazz.getSimpleName() + " не имеет аннотации @Table");
        }

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.title();

        Field[] fields = clazz.getDeclaredFields();
        StringBuilder createTableQuery = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableName + " (");

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                String columnName = column.name();
                String columnType = column.type();

                if (createTableQuery.length() > ("CREATE TABLE IF NOT EXISTS " + tableName + " (").length()) {
                    createTableQuery.append(", ");
                }
                createTableQuery.append(columnName).append(" ").append(columnType);
            }
        }

        createTableQuery.append(");");

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableQuery.toString());
        }
    }
}
