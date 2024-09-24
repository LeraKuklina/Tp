package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:hamster.db");

        TableCreator.createTable(Hamster.class, connection);

        Hamster hamster = new Hamster("Lola", 2, HamsterColor.BROWN);
        TableInserter.insertIntoTable(hamster, connection);

        connection.close();
    }
}
