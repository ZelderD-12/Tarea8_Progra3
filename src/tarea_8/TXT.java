 
package tarea_8;

import dbconnection.dbconn;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class TXT {
    
  
    public static File archivo = new File("./Historial/historial.txt");
    public static FileWriter escritor;   
    public static PrintWriter lineas;
    public static FileReader lector;
    
    // Crea el archivo txt, verifica si ya tienen datos y registra los IDs desde la DB
    public void TXTArchivo(dbconn conexion)  {
        // Crear el archivo si no existe
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escritor = new FileWriter(archivo, true);
                lineas = new PrintWriter(escritor, true);
                lineas.println("  |ID |            | Nombre |");
                System.out.println("Archivo creado correctamente");
                lineas.close();
                escritor.close();
            } catch (IOException e) {
                System.out.println("" + e);
            }
        }
        
        // Obtener solo la lista de IDs de la conexión
        ArrayList<Integer> ids = conexion.getListaIds();
        
        // Leer los IDs que ya están en el archivo para no duplicarlos de nuevo :p
        ArrayList<Integer> idsExistentes = new ArrayList<>();
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                // Extraer el ID de cada línea
                int inicioId = linea.indexOf("|") + 1;
                int finId = linea.indexOf("|", inicioId);
                if (inicioId != 0 && finId != -1) {
                    String idStr = linea.substring(inicioId, finId).trim();
                    if (!idStr.isEmpty() && !idStr.equals("ID")) {
                        try {
                            int id = Integer.parseInt(idStr);
                            idsExistentes.add(id);
                        } catch (NumberFormatException e) {
                             
                        }
                    }
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        
        // Verificar si hay IDs nuevos para añadir
        boolean hayNuevosIds = false;
        ArrayList<Integer> idsAEscribir = new ArrayList<>();
        
        for (int id : ids) {
            if (!idsExistentes.contains(id)) {
                idsAEscribir.add(id);
                hayNuevosIds = true;
            }
        }
        
        // Solo escribir si hay IDs nuevos
        if (hayNuevosIds) {
            try {
                escritor = new FileWriter(archivo, true);
                lineas = new PrintWriter(escritor, true);
                
                // Guardar solo los IDs nuevos dejando espacio para el nombre
                for (int id : idsAEscribir) {
                    lineas.println("  |" + id + " |            |  |");
                }
                
                lineas.close();
                escritor.close();
                System.out.println("Nuevos IDs guardados en archivo");
            } catch (IOException e) {
                System.out.println("Error al guardar en archivo: " + e);
            }
        } else {
            System.out.println("No hay nuevos IDs para guardar");
        }
    }
    
    // Método para guardar un nombre asociado a un ID específico
    public boolean guardarNombre(String id, String nombre) {
        File archivoOriginal = archivo;
        File archivoTemporal = new File("./Historial/temp.txt");
        boolean encontrado = false;
        
        try {
            // Crear un archivo temporal , no tocar!
            if (!archivoTemporal.exists()) {
                archivoTemporal.createNewFile();
            }
            
            // Leer el archivo original
            BufferedReader lector = new BufferedReader(new FileReader(archivoOriginal));
            PrintWriter escritor = new PrintWriter(new FileWriter(archivoTemporal));
            
            String linea;
            
            // Leer cada línea del archivo original
            while ((linea = lector.readLine()) != null) {
                 
                String patronBusqueda = "|" + id + " |";
                
                if (linea.contains(patronBusqueda)) {
            
            int penultimoSeparador = linea.lastIndexOf("|", linea.lastIndexOf("|") - 1);
             
            String nuevaLinea = linea.substring(0, penultimoSeparador + 1) + " " + nombre + " |";
            escritor.println(nuevaLinea);
            encontrado = true;
                } else {
                    escritor.println(linea);
                }
            }
            
            lector.close();
            escritor.close();
            
            if (encontrado) {
                archivoOriginal.delete();                                 
                archivoTemporal.renameTo(archivoOriginal);
                System.out.println("Nombre guardado correctamente");
            } else {
                // Si no encontramos el ID, eliminar el archivo temporal
                archivoTemporal.delete();
                System.out.println("No se encontró el ID especificado");
            }           
        } catch (IOException ex) {
            System.out.println("Error al guardar nombre en el archivo: " + ex.getMessage());
            return false;
        }       
        return encontrado;
    }
    
    // Método para obtener una lista de IDs y nombres desde el archivo TXT
    public ArrayList<String[]> obtenerIdsYNombres() {
        ArrayList<String[]> resultado = new ArrayList<>();
        
        try {
            if (archivo.exists()) {
                BufferedReader lector = new BufferedReader(new FileReader(archivo));
                String linea;
                
                while ((linea = lector.readLine()) != null) {
                    // Saltar la línea de encabezado
                    if (linea.contains("|ID |") || linea.trim().isEmpty()) {
                        continue;
                    }
                    
                    // Extraer ID y Nombre
                    String[] partes = linea.split("\\|");
                    if (partes.length >= 4) {
                        String id = partes[1].trim();
                        String nombre = partes[3].trim();
                        
                        // Guardar el par ID y nombre
                        resultado.add(new String[]{id, nombre});
                    }
                }
                lector.close();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e);
        }
        
        return resultado;
    }
    
    //  método  para modificar el nombre asociado a un ID
    public boolean reemplazarIdPorNombreEnTxt(String id, String nombre) {
        return guardarNombre(id, nombre);
    }


    }


   

