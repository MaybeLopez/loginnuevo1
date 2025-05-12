package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static Connection conectar() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=ProyectoBD;"
                   + "user=usersql;password=root;"
                   + "encrypt=false;trustServerCertificate=true;";
        try {
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Conexión exitosa desde TestConnection!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}
