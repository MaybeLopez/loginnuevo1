package com.mycompany.loginnuevo;

import bd.TestConnection;
import vista.login;
import java.sql.Connection;

/**
 *
 * @author CHEN
 */
public class Loginnuevo {
    public static void main(String[] args) {
        Connection conn = TestConnection.conectar();

        if (conn != null) {
            System.out.println("Conectado correctamente. Abriendo login...");
            new login().setVisible(true);
        } else {
            System.out.println("Error de conexión. No se puede abrir la aplicación.");
        }
    }
}


