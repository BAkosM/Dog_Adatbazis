package hu.petrik.adatbazis;

import java.sql.Connection;
import java.sql.DriverManager;

public class DogDB {
    Connection conn;
    public static String DB_DRIVER = "mysql";
    public static String DB_USER = "root";
    public static String DB_PASS = "";

    public DogDB() {
        String url = String.format("");
        conn = DriverManager.getConnection(url ,DB_USER, DB_PASS);
    }

    public void createDog() {

    }

    public void readDogs() {

    }

    public void updateDogs() {

    }

    public void deleteDogs() {

    }
}