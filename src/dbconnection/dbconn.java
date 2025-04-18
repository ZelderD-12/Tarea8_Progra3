/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WillGP
 */
public class dbconn {

    public static void cargarDatosEnTabla(JTable jtblDatos, Component parent) {
        // Pedir los datos para la conexión
        String host = JOptionPane.showInputDialog(parent, "Ingrese el host (ej: localhost):");
        if (host == null) {
            return;
        }

        String port = JOptionPane.showInputDialog(parent, "Ingrese el puerto (ej: 3306):");
        if (port == null) {
            return;
        }

        String dbName = JOptionPane.showInputDialog(parent, "Ingrese el nombre de la base de datos:");
        if (dbName == null) {
            return;
        }

        String user = JOptionPane.showInputDialog(parent, "Ingrese el usuario:");
        if (user == null) {
            return;
        }

        String password = JOptionPane.showInputDialog(parent, "Ingrese la contraseña:");
        if (password == null) {
            return;
        }

        String tabla = JOptionPane.showInputDialog(parent, "Ingrese el nombre de la tabla:");
        if (tabla == null) {
            return;
        }

        try {
            // Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crear la conexión con puerto personalizado
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useSSL=true&requireSSL=true&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, user, password);

            // Consulta a la tabla
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabla);

            // Obtener metadatos para las columnas
            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            // Crear modelo de tabla sin la primera columna
            DefaultTableModel model = new DefaultTableModel();
            for (int i = 2; i <= columnas; i++) {
                model.addColumn(meta.getColumnName(i));
            }

            // Llenar datos sin la primera columna
            while (rs.next()) {
                Object[] fila = new Object[columnas - 1];
                for (int i = 2; i <= columnas; i++) {
                    fila[i - 2] = rs.getObject(i);
                }
                model.addRow(fila);
            }

            // Mostrar datos en la tabla
            jtblDatos.setModel(model);

            // Cerrar conexión
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(parent, "Error al conectar o consultar la base de datos:\n" + e.getMessage());
        }
    }
}
