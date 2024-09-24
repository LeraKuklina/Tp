package org.example;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TableInserter {

    public static void insertIntoTable(Object obj, Connection connection) throws Exception {
        Class<?> clazz = obj.getClass();

        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException("Класс должен быть размечен аннотацией @Table");
        }

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.title();

        StringBuilder insertQuery = new StringBuilder("INSERT INTO ");
        insertQuery.append(tableName).append(" (");

        StringBuilder valuesPart = new StringBuilder("VALUES (");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                insertQuery.append(column.name()).append(", ");
                valuesPart.append("?, ");
            }
        }

        insertQuery.setLength(insertQuery.length() - 2);
        valuesPart.setLength(valuesPart.length() - 2);
        insertQuery.append(") ").append(valuesPart).append(");");

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery.toString())) {

            int index = 1;
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    preparedStatement.setObject(index++, field.get(obj));
                }
            }

            preparedStatement.executeUpdate();
        }
    }
}
