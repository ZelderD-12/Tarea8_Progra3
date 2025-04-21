/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WillGP
 */
public class dbconn {
    private ArrayList <Integer> ids = new ArrayList <>(); 

    public static String host, port, dbName, user, password, tabla;

    public static void cargarDatosEnTabla(JTable jtblDatos, Component parent) {
        // Pedir los datos para la conexión
        host = JOptionPane.showInputDialog(parent, "Ingrese el host (ej: localhost):");
        if (host == null) {
            return;
        }

        port = JOptionPane.showInputDialog(parent, "Ingrese el puerto (ej: 3306):");
        if (port == null) {
            return;
        }

        dbName = JOptionPane.showInputDialog(parent, "Ingrese el nombre de la base de datos:");
        if (dbName == null) {
            return;
        }

        user = JOptionPane.showInputDialog(parent, "Ingrese el usuario:");
        if (user == null) {
            return;
        }

        password = JOptionPane.showInputDialog(parent, "Ingrese la contraseña:");
        if (password == null) {
            return;
        }

        tabla = JOptionPane.showInputDialog(parent, "Ingrese el nombre de la tabla:");
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

            if (columnas < 2) {
                JOptionPane.showMessageDialog(parent, "La tabla no tiene una segunda columna.");
                return;
            }

            // Crear modelo solo con la segunda columna
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn(meta.getColumnName(2));  // Solo la columna 2

            // Agregar los datos de la segunda columna
            while (rs.next()) {
                Object[] fila = new Object[1];
                fila[0] = rs.getObject(2);  // Solo la columna 2
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

    public static String obtenerNombreColumna(int indice) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useSSL=true&requireSSL=true&serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, user, password);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabla + " LIMIT 1");
        ResultSetMetaData meta = rs.getMetaData();
        String nombreColumna = meta.getColumnName(indice);

        rs.close();
        stmt.close();
        conn.close();

        return nombreColumna;
    }
    
    public static void actualizarColumna3PorColumna2(String valorColumna2, String nuevoValorColumna3, Component parent) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useSSL=true&requireSSL=true&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, user, password);

            // Obtener nombres de columnas antes de armar la consulta
            String nombreCol3 = obtenerNombreColumna(3);
            String nombreCol2 = obtenerNombreColumna(2);

            String sql = "UPDATE " + tabla + " SET " + nombreCol3 + " = ? WHERE " + nombreCol2 + " = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nuevoValorColumna3);
            ps.setString(2, valorColumna2);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(parent, "Dato actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(parent, "No se encontró la fila para actualizar.");
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(parent, "Error al actualizar los datos:\n" + e.getMessage());
        }
    }

  
    
        public void mostrarMensajes() {
      try {
        // Limpiar la lista de IDs antes de cargar nuevos
        ids.clear();
           
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useSSL=true&requireSSL=true&serverTimezone=UTC";
        Connection conn = DriverManager.getConnection(url, user, password);
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT idmensaje FROM " + tabla);
        
        while (rs.next()) {
            int id = rs.getInt("idmensaje");
            ids.add(id);
            System.out.println("ID encontrado: " + id);
        }
        
        System.out.println("Total de IDs recuperados: " + ids.size());
        
        
        rs.close();
        stmt.close();
        conn.close();
        
    } catch (Exception ex) {
        System.out.println("Error al obtener mensajes: " + ex.getMessage());
        ex.printStackTrace();
    }
}
    
     public ArrayList<Integer> getListaIds() {
       return ids;
   }  
    
    
    
    
}
