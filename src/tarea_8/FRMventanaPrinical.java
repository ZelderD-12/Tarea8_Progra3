package tarea_8;

import dbconnection.*;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class FRMventanaPrinical extends javax.swing.JFrame {
    private JComboBox<String> comboNombres;
    public String Nombre;
    public String ID; 
    private TXT gestorTXT = new TXT(); 
    Encriptacion ecript = new Encriptacion();
    public String valorseleccionado;
    
   private String idSeleccionado;
    Control controlador;

    public FRMventanaPrinical() {
        initComponents();
        controlador = new Control(scrolArbol, paneldelArbol, txtFrase);
 
    getContentPane().setLayout(new FlowLayout());
    
    // ni se atreban a tocar mi combo box , que si no, lo arreglan ustedes -_- 
    comboNombres = new JComboBox<>();
    comboNombres.setBounds(950, 185, 200, 30);  
   jPanel1.add(comboNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 369, 150, 30));
     
    getContentPane().add(jPanel1);
 
    cargarComboBox();
     configurarComboBoxListener(); 
     
    revalidate();
    repaint();  
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrolArbol = new javax.swing.JScrollPane();
        paneldelArbol = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFrase = new javax.swing.JTextArea();
        btnArmarArbol = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblMensaje = new javax.swing.JTable();
        jbtnsave = new javax.swing.JButton();
        jbtnconn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtadescifrado = new javax.swing.JTextArea();
        Registrar = new javax.swing.JButton();
        btnencriptar = new javax.swing.JButton();
        txtcontador = new javax.swing.JLabel();
        btnmensaje = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtO = new javax.swing.JTextArea();
        label1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout paneldelArbolLayout = new javax.swing.GroupLayout(paneldelArbol);
        paneldelArbol.setLayout(paneldelArbolLayout);
        paneldelArbolLayout.setHorizontalGroup(
            paneldelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        paneldelArbolLayout.setVerticalGroup(
            paneldelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );

        scrolArbol.setViewportView(paneldelArbol);

        jPanel1.add(scrolArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 720, 320));

        txtFrase.setColumns(20);
        txtFrase.setRows(5);
        jScrollPane1.setViewportView(txtFrase);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 330, 70));

        btnArmarArbol.setText("Enviar");
        btnArmarArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArmarArbolActionPerformed(evt);
            }
        });
        jPanel1.add(btnArmarArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 330, -1));

        jtblMensaje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Mensaje"
            }
        ));
        jtblMensaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblMensajeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtblMensaje);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 430, 170));

        jbtnsave.setText("Guardar en DB");
        jbtnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 220, 180, 60));

        jbtnconn.setText("Conectar DB");
        jbtnconn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnconnActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnconn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 180, 60));

        jtadescifrado.setColumns(20);
        jtadescifrado.setRows(5);
        jScrollPane3.setViewportView(jtadescifrado);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 430, 150));

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 120, 30));

        btnencriptar.setText("Encriptar");
        btnencriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnencriptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnencriptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 300, -1, -1));

        txtcontador.setBackground(new java.awt.Color(255, 255, 0));
        txtcontador.setFont(new java.awt.Font("Tw Cen MT", 2, 5)); // NOI18N
        txtcontador.setForeground(new java.awt.Color(255, 255, 0));
        txtcontador.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtcontadorAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(txtcontador, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 110, 40));

        btnmensaje.setText("Mostrar Mensaje");
        btnmensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmensajeActionPerformed(evt);
            }
        });
        jPanel1.add(btnmensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 130, 50));

        txtO.setColumns(20);
        txtO.setRows(5);
        jScrollPane4.setViewportView(txtO);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 190, 100));

        label1.setText("jLabel1");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

      // Método para configurar el listener del comboBox
private void configurarComboBoxListener() {
    comboNombres.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                idSeleccionado = obtenerIdSeleccionado();
                System.out.println("ID seleccionado: " + idSeleccionado);
                
                // Aquí hagan lo que se les de la gana al seleccionar el id :p
            }
        }
    });
}

   //****************************************************************************************************
// Método para obtener el ID seleccionado en el comboBox
private String obtenerIdSeleccionado() {
    // Verificar que haya un elemento seleccionado
    if (comboNombres.getSelectedIndex() == -1 || comboNombres.getSelectedItem() == null) {
        return null;
    }
    
    String seleccion = comboNombres.getSelectedItem().toString();
    
    
    if (seleccion.equals("No hay registros disponibles")) {
        return null;
    }
    
    
    int separadorIndex = seleccion.indexOf(" - ");
    if (separadorIndex != -1) {
        return seleccion.substring(0, separadorIndex).trim();
    }
    
    return null;
}

  //**********************************************************************************************
    
    // Método para validar si el ID existe en el archivo TXT
private boolean validarEnTxt(String id) { 
    File archivo = new File("./Historial/historial.txt");
    boolean encontrado = false;
    try {
        if (archivo.exists()) {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            // Buscar el ID en cada línea del archivo
            while ((linea = lector.readLine()) != null) {
                String patronBusqueda = "|" + id + " |";
                if (linea.contains(patronBusqueda)) {
                    encontrado = true;
                    break;
                }
            }
            lector.close();
        }
    } catch (IOException ex) {
        System.out.println("Error al leer el archivo: " + ex.getMessage());
    }
    return encontrado;
}
   //********************************************************************************************** 
       // Método para solicitar datos y evitar valores vacíos
    private String solicitarDato(String mensaje) {
        String dato;
        do {
            dato = JOptionPane.showInputDialog(null, mensaje, "Conexión a la Base de Datos", JOptionPane.QUESTION_MESSAGE);
            if (dato == null || dato.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Este campo es obligatorio. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (dato == null || dato.trim().isEmpty());
        return dato;
    }
   //************************************************************************************************* 
// Método para cargar el comboBox con los IDs/Nombres del archivo TXT
    private void cargarComboBox() {
    
    comboNombres.removeAllItems();
    // Obtener IDs y nombres del archivo TXT
    ArrayList<String[]> idsYNombres = gestorTXT.obtenerIdsYNombres();
    // añade  cada ID/Nombre al comboBox de la pantalla :p
    for (String[] par : idsYNombres) {
        String id = par[0];
        String nombre = par[1];
        
       
        if (nombre == null || nombre.trim().isEmpty()) {
            comboNombres.addItem(id + " - [Sin nombre]");
        } else {
            comboNombres.addItem(id + " - " + nombre);
        }
    }
    
     
     
    if (comboNombres.getItemCount() == 0) {
        comboNombres.addItem("No hay registros disponibles");
    }
}
    
    
    private void btnArmarArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmarArbolActionPerformed
        String letra = txtFrase.getText();
        controlador.insertar(letra);
        
    }//GEN-LAST:event_btnArmarArbolActionPerformed

    private void jbtnconnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnconnActionPerformed
         
    dbconn.cargarDatosEnTabla(jtblMensaje, this);
    
    dbconn conexion = new dbconn();
    conexion.mostrarMensajes();  
    
    // Y actualizar el archivo TXT
    TXT txt = new TXT();
    txt.TXTArchivo(conexion);
    
    // Actualizar el comboBox después de cargar los nuevos datos
    cargarComboBox();
    }//GEN-LAST:event_jbtnconnActionPerformed

    private void jbtnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsaveActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = jtblMensaje.getSelectedRow();

        if (filaSeleccionada != -1) {
            String valorCol2 = jtblMensaje.getValueAt(filaSeleccionada, 0).toString(); // solo hay una columna visible
            String nuevoTexto = jtadescifrado.getText();

            dbconn.actualizarColumna3PorColumna2(valorCol2, nuevoTexto, this);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila primero.");
        }

    }//GEN-LAST:event_jbtnsaveActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        
        ID = solicitarDato("Ingrese el ID a registrar");
        Nombre = solicitarDato("Ingrese su nombre:");

        // Validar que el ID existe en el archivo TXT
        if (validarEnTxt(ID)) {
             
            boolean registroExitoso = gestorTXT.guardarNombre(ID, Nombre);

            if (registroExitoso) {
                JOptionPane.showMessageDialog(null, "El ID " + ID + " ha sido registrado con el nombre: " + Nombre,
                    "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

                // Actualizar el comboBox después de registrar un nuevo nombre
                cargarComboBox();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el nombre para el ID en el archivo.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El ID " + ID + " no se encontró en el archivo de historial.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_RegistrarActionPerformed

    private void btnencriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnencriptarActionPerformed
        try {
            jtadescifrado.setText(ecript.IniciarEncriptacion(valorseleccionado));
        } catch (InterruptedException ex) {
            Logger.getLogger(FRMventanaPrinical.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnencriptarActionPerformed

    private void jtblMensajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblMensajeMouseClicked
        int fila = jtblMensaje.getSelectedRow();      // Fila seleccionada
        int columna = jtblMensaje.getSelectedColumn(); // Columna seleccionada

        if (fila != -1 && columna != -1) {
            Object valor = jtblMensaje.getValueAt(fila, columna); // Obtener el valor
            valorseleccionado = valor.toString();
        }
    }//GEN-LAST:event_jtblMensajeMouseClicked

    private void txtcontadorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtcontadorAncestorAdded
     
    }//GEN-LAST:event_txtcontadorAncestorAdded

    private void btnmensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmensajeActionPerformed
   
    // Inicializar componentes y variables
    final JTextArea jtadescifrado = this.jtadescifrado; // Asumiendo que tienes un JTextArea llamado jtadescifrado
    final JLabel label1 = this.label1; // Asumiendo que tienes un JLabel llamado label1
    final AtomicInteger contador = new AtomicInteger(0);
    final AtomicBoolean operacionCompletada = new AtomicBoolean(false);
    
    // Limpiar contenido anterior
    jtadescifrado.setText("");
    label1.setText("Procesando...");
    
    // Crear un hilo para el proceso de decodificación
    Thread hiloDecodificacion = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                // Obtener datos del panel del árbol
                ArbolBinario paneldelArbol = obtenerArbolDePanelActual(); // Método que debes implementar
                
                if (paneldelArbol == null) {
                    SwingUtilities.invokeLater(() -> {
                        jtadescifrado.setText("Error: No se pudo obtener el árbol de decodificación");
                        label1.setText("Error");
                    });
                    return;
                }
                
                // Consultar la base de datos para obtener el mensaje cifrado
                String mensajeCifrado = consultarMensajeDeBD(); // Método que debes implementar
                
                if (mensajeCifrado == null || mensajeCifrado.isEmpty()) {
                    SwingUtilities.invokeLater(() -> {
                        jtadescifrado.setText("No hay mensajes para decodificar");
                        label1.setText("Completado: 0 mensajes");
                    });
                    return;
                }
                
                // Iniciar proceso de decodificación
                final StringBuilder mensajeDecodificado = new StringBuilder();
                final String[] palabras = mensajeCifrado.split("\\s+");
                
                for (String palabra : palabras) {
                    // Decodificar cada palabra usando el árbol
                    String palabraDecodificada = decodificarPalabra(palabra, paneldelArbol);
                    mensajeDecodificado.append(palabraDecodificada).append(" ");
                    
                    // Actualizar contador
                    contador.incrementAndGet();
                    
                    final int contadorActual = contador.get();
                    SwingUtilities.invokeLater(() -> {
                        label1.setText("Palabras procesadas: " + contadorActual);
                    });
                    
                    // Pequeña pausa para ver el progreso
                    Thread.sleep(50);
                }
                
                // Mostrar resultado final
                final String resultadoFinal = mensajeDecodificado.toString().trim();
                operacionCompletada.set(true);
                
                SwingUtilities.invokeLater(() -> {
                    jtadescifrado.setText(resultadoFinal);
                    label1.setText("Completado: " + contador.get() + " palabras decodificadas");
                });
                
            } catch (Exception e) {
                operacionCompletada.set(true);
                final String mensajeError = "Error en la decodificación: " + e.getMessage();
                
                SwingUtilities.invokeLater(() -> {
                    jtadescifrado.setText(mensajeError);
                    label1.setText("Error");
                });
                
                e.printStackTrace();
            }
        }
    });
    
    // Iniciar el hilo de decodificación
    hiloDecodificacion.start();
    
    // Establecer un temporizador para cancelar la operación si tarda más de 3 minutos
    Timer temporizador = new Timer(180000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!operacionCompletada.get()) {
                hiloDecodificacion.interrupt();
                
                SwingUtilities.invokeLater(() -> {
                    jtadescifrado.setText("La operación fue cancelada debido a que excedió el tiempo límite (3 minutos)");
                    label1.setText("Cancelado por tiempo");
                });
            }
        }
    });
    
    temporizador.setRepeats(false);
    temporizador.start();
}

/**
 * Método para obtener un mensaje cifrado de la base de datos
 * @return El mensaje cifrado o null si no se encuentra
 */
private String consultarMensajeDeBD() {
    String mensajeCifrado = null;
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
        // Configurar la conexión a la base de datos
        conn = obtenerConexionBD(); // Método que debes implementar
        
        // Consulta SQL para obtener el mensaje
        String sql = "SELECT mensaje_cifrado FROM mensajes WHERE estado = 'pendiente' ORDER BY fecha_creacion ASC LIMIT 1";
        stmt = conn.prepareStatement(sql);
        
        // Ejecutar la consulta
        rs = stmt.executeQuery();
        
        if (rs.next()) {
            mensajeCifrado = rs.getString("mensaje_cifrado");
            
            // Actualizar el estado del mensaje para que no se procese de nuevo
            PreparedStatement updateStmt = conn.prepareStatement(
                "UPDATE mensajes SET estado = 'procesado' WHERE mensaje_cifrado = ?");
            updateStmt.setString(1, mensajeCifrado);
            updateStmt.executeUpdate();
            updateStmt.close();
        }
    } catch (SQLException e) {
        System.err.println("Error al consultar la base de datos: " + e.getMessage());
        e.printStackTrace();
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    return mensajeCifrado;
}

/**
 * Método para decodificar una palabra usando un árbol binario
 * @param palabraCifrada La palabra cifrada a decodificar
 * @param arbol El árbol binario usado para decodificación
 * @return La palabra decodificada
 */
private String decodificarPalabra(String palabraCifrada, ArbolBinario arbol) {
    StringBuilder palabraDecodificada = new StringBuilder();
    
    // Implementación de la lógica de decodificación usando el árbol
    // Este es un ejemplo simplificado; ajústalo según tu implementación específica del árbol
    for (int i = 0; i < palabraCifrada.length(); i++) {
        char c = palabraCifrada.charAt(i);
        
        // Ejemplo: Si el carácter es '0', ir al nodo izquierdo; si es '1', ir al nodo derecho
        NodoArbol nodoActual = arbol.getRaiz();
        
        // Recorrido del árbol según el carácter
        // (Esta es una implementación conceptual, ajústala a tu modelo de árbol)
        if (c == '0') {
            if (nodoActual.getIzquierdo() != null) {
                nodoActual = nodoActual.getIzquierdo();
            }
        } else if (c == '1') {
            if (nodoActual.getDerecho() != null) {
                nodoActual = nodoActual.getDerecho();
            }
        }
        
        // Agregar el valor del nodo al resultado
        if (nodoActual != null && nodoActual.getValor() != null) {
            palabraDecodificada.append(nodoActual.getValor());
        }
    }
    
    return palabraDecodificada.toString();
}

/**
 * Método para obtener el árbol binario desde el panel de la interfaz
 * @return El árbol binario o null si no se puede obtener
 */
private ArbolBinario obtenerArbolDePanelActual() {
    // Implementación dependiente de tu estructura de UI
    // Asumiendo que tienes un panel que contiene la visualización del árbol
    // y tiene un método para obtener la estructura de datos del árbol
    
    /**
 * Método para obtener el árbol binario desde el panel de la interfaz
 * @return El árbol binario o null si no se puede obtener
 */
    /*private ArbolBinario obtenerArbolDePanelActual() {*/
    // Obtener la referencia al panel
    JPanel panelArbol = this.paneldelArbol;
    
    if (panelArbol != null) {
        // Opción 1: Si el árbol está almacenado como una propiedad del panel
        Object arbolObj = panelArbol.getClientProperty("arbolBinario");
        if (arbolObj instanceof ArbolBinario) {
            return (ArbolBinario) arbolObj;
        }
        
        // Opción 2: Si el árbol se puede recuperar de algún componente hijo
        for (Component comp : panelArbol.getComponents()) {
            if (comp instanceof JTree) {
                // Si hay un JTree, podemos construir nuestro árbol binario a partir de él
                return construirArbolBinarioDesdeJTree((JTree) comp);
            }
        }
        
        // Opción 3: Si el panel tiene una variable de instancia que representa el árbol
        // Esto requiere usar reflexión, que es una técnica avanzada
        try {
            Field field = panelArbol.getClass().getDeclaredField("arbolBinario");
            field.setAccessible(true);
            Object valor = field.get(panelArbol);
            if (valor instanceof ArbolBinario) {
                return (ArbolBinario) valor;
            }
        } catch (Exception e) {
            // Ignorar errores de reflexión, intentar otro método
        }
    }
    
    System.err.println("No se pudo obtener el árbol del panel. Creando uno por defecto.");
    // Si no se puede obtener, crear uno nuevo como último recurso
    return new ArbolBinario();
}

/**
 * Construye un ArbolBinario a partir de un JTree
 * @param jTree El JTree de la interfaz gráfica
 * @return Un nuevo ArbolBinario
 */
private ArbolBinario construirArbolBinarioDesdeJTree(JTree jTree) {
    ArbolBinario arbol = new ArbolBinario();
    
    // Obtener el nodo raíz del JTree
    DefaultMutableTreeNode raizUI = (DefaultMutableTreeNode) jTree.getModel().getRoot();
    
    // Crear el nodo raíz para nuestro ArbolBinario
    NodoArbol raiz = new NodoArbol();
    raiz.setValor(raizUI.getUserObject().toString());
    arbol.setRaiz(raiz);
    
    // Construir el resto del árbol recursivamente
    construirNodosDelArbol(raiz, raizUI);
    
    return arbol;
}

/**
 * Método auxiliar para construir los nodos del árbol binario
 * @param nodoArbol El nodo actual en nuestro ArbolBinario
 * @param nodoUI El nodo correspondiente en el JTree
 */
private void construirNodosDelArbol(NodoArbol nodoArbol, DefaultMutableTreeNode nodoUI) {
    // Si hay al menos un hijo, considerarlo como hijo izquierdo
    if (nodoUI.getChildCount() > 0) {
        DefaultMutableTreeNode hijoIzqUI = (DefaultMutableTreeNode) nodoUI.getChildAt(0);
        NodoArbol hijoIzq = new NodoArbol();
        hijoIzq.setValor(hijoIzqUI.getUserObject().toString());
        nodoArbol.setIzquierdo(hijoIzq);
        construirNodosDelArbol(hijoIzq, hijoIzqUI);
    }
    
    // Si hay al menos dos hijos, considerar el segundo como hijo derecho
    if (nodoUI.getChildCount() > 1) {
        DefaultMutableTreeNode hijoDerUI = (DefaultMutableTreeNode) nodoUI.getChildAt(1);
        NodoArbol hijoDer = new NodoArbol();
        hijoDer.setValor(hijoDerUI.getUserObject().toString());
        nodoArbol.setDerecho(hijoDer);
        construirNodosDelArbol(hijoDer, hijoDerUI);
    }
}

/**
 * Método para obtener una conexión a la base de datos
 * @return Una conexión a la base de datos
 * @throws SQLException si hay un error al conectar
 */
private Connection obtenerConexionBD() throws SQLException {
    // Actualizado con las credenciales proporcionadas
    String url = "jdbc:mysql://212.1.211.51:3306/u878723730_whatsapp_db";
    String usuario = "u878723730_mysqladmin";
    String password = "12345678.Umg";
    
    try {
        // Asegurarse de que el driver esté cargado
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, usuario, password);
    } catch (ClassNotFoundException e) {
        System.err.println("Error al cargar el driver JDBC: " + e.getMessage());
        throw new SQLException("No se pudo cargar el driver JDBC", e);
    }
}
// Clases internas para el ejemplo (reemplazar con tus propias implementaciones)
class ArbolBinario {
    private NodoArbol raiz;
    
    public NodoArbol getRaiz() {
        return raiz;
    }
    
    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
}

class NodoArbol {
    private String valor;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    public String getValor() {
        return valor;
    }
    
    public NodoArbol getIzquierdo() {
        return izquierdo;
    }
    
    public NodoArbol getDerecho() {
        return derecho;
    }

        private void setDerecho(NodoArbol hijoDer) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void setValor(String toString) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void setIzquierdo(NodoArbol hijoIzq) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

class PanelArbol {
    private ArbolBinario arbolBinario;
    
    public ArbolBinario getArbolBinario() {
        return arbolBinario;
    }

    }//GEN-LAST:event_btnmensajeActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRMventanaPrinical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMventanaPrinical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMventanaPrinical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMventanaPrinical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMventanaPrinical().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Registrar;
    private javax.swing.JButton btnArmarArbol;
    private javax.swing.JButton btnencriptar;
    private javax.swing.JButton btnmensaje;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbtnconn;
    private javax.swing.JButton jbtnsave;
    private javax.swing.JTextArea jtadescifrado;
    private javax.swing.JTable jtblMensaje;
    private javax.swing.JLabel label1;
    private javax.swing.JPanel paneldelArbol;
    private javax.swing.JScrollPane scrolArbol;
    private javax.swing.JTextArea txtFrase;
    private javax.swing.JTextArea txtO;
    private javax.swing.JLabel txtcontador;
    // End of variables declaration//GEN-END:variables
}
