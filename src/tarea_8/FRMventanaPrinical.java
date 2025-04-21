package tarea_8;

import dbconnection.*;
import java.util.Optional;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
cronometro crono0metro;
    
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
        txttiempo = new javax.swing.JLabel();

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
        jPanel1.add(txtcontador, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 110, 40));

        btnmensaje.setText("Mostrar Mensaje");
        btnmensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmensajeActionPerformed(evt);
            }
        });
        jPanel1.add(btnmensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 130, 50));

        txtO.setColumns(20);
        txtO.setRows(5);
        jScrollPane4.setViewportView(txtO);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 190, 100));

        label1.setText("jLabel1");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 500, 130, 40));

        txttiempo.setText("jLabel1");
        txttiempo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txttiempoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(txttiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
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
    
    // Obtener el texto actual del txtO y agregar la nueva letra
    String textoActual = txtO.getText();
    txtO.setText(textoActual + letra);
    
    // Opcional: limpiar el campo de entrada después de insertar
    txtFrase.setText("");

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

    private void btnmensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmensajeActionPerformed
    // Inicializar componentes y variables
    final JTextArea jtadescifrado = this.jtadescifrado;
    final JLabel label1 = this.label1;
    final AtomicInteger contador = new AtomicInteger(0);
    final AtomicBoolean operacionCompletada = new AtomicBoolean(false);
    
    // Limpiar contenido anterior
    jtadescifrado.setText("");
    label1.setText("Procesando...");
    
    // Iniciar cronómetro (3 minutos)
    final CronometroDecodificacion cronometro = new CronometroDecodificacion(txttiempo);
    
    // Crear un hilo para el proceso de decodificación
    Thread hiloDecodificacion = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                // Obtener datos del panel del árbol
                ArbolBinario paneldelArbol = obtenerArbolDePanelActual();
                
                if (paneldelArbol == null) {
                    SwingUtilities.invokeLater(() -> {
                        jtadescifrado.setText("Error: No se pudo obtener el árbol de decodificación");
                        label1.setText("Error");
                        cronometro.detener("Error - Árbol no disponible");
                    });
                    return;
                }
                
                // Intentar consultar la base de datos
                String mensajeCifrado = null;
                try {
                    mensajeCifrado = consultarMensajeDeBD();
                } catch (Exception e) {
                    System.err.println("Error al consultar BD: " + e.getMessage());
                }
                
                if (mensajeCifrado != null && !mensajeCifrado.isEmpty()) {
                    // Proceso de decodificación de mensaje de BD
                    final StringBuilder mensajeDecodificado = new StringBuilder();
                    final String[] palabras = mensajeCifrado.split("\\s+");
                    
                    for (String palabra : palabras) {
                        if (Thread.currentThread().isInterrupted()) {
                            throw new InterruptedException("Proceso cancelado");
                        }
                        
                        String palabraDecodificada = decodificarPalabra(palabra, paneldelArbol);
                        mensajeDecodificado.append(palabraDecodificada).append(" ");
                        contador.incrementAndGet();
                        
                        final int contadorActual = contador.get();
                        SwingUtilities.invokeLater(() -> {
                            label1.setText("Palabras procesadas: " + contadorActual);
                        });
                        
                        Thread.sleep(50);
                    }
                    
                    final String resultadoFinal = mensajeDecodificado.toString().trim();
                    operacionCompletada.set(true);
                    
                    SwingUtilities.invokeLater(() -> {
                        jtadescifrado.setText(resultadoFinal);
                        label1.setText("Completado: " + contador.get() + " palabras decodificadas");
                        cronometro.detener("Decodificación exitosa");
                        analizarYMostrarCombinaciones(true);
                    });
                } else {
                    // No hay mensajes en BD - procesar txtO
                    SwingUtilities.invokeLater(() -> {
                        analizarYMostrarCombinaciones(false);
                        cronometro.detener("Análisis de letras");
                        if (jtadescifrado.getText().isEmpty()) {
                            jtadescifrado.setText("No hay mensajes para decodificar en BD\nMostrando análisis de letras en txtO");
                        }
                    });
                }
                
            } catch (InterruptedException e) {
                SwingUtilities.invokeLater(() -> {
                    jtadescifrado.setText("Proceso cancelado por tiempo");
                    label1.setText("Cancelado");
                    cronometro.detener("Cancelado por tiempo");
                });
            } catch (Exception e) {
                operacionCompletada.set(true);
                SwingUtilities.invokeLater(() -> {
                    jtadescifrado.setText("Error: " + e.getMessage() + "\n\nAnalizando letras en txtO...");
                    label1.setText("Error");
                    cronometro.detener("Error en proceso");
                    analizarYMostrarCombinaciones(false);
                });
                e.printStackTrace();
            }
        }
    });
    
    hiloDecodificacion.start();
    
    // Temporizador de seguridad (3 minutos)
    Timer temporizador = new Timer(180000, e -> {
        if (!operacionCompletada.get()) {
            hiloDecodificacion.interrupt();
        }
    });
    temporizador.setRepeats(false);
    temporizador.start();
}

// Clase Cronometro mejorada para la decodificación
class CronometroDecodificacion {
    private JLabel labelTiempo;
    private Thread hiloCronometro;
    private boolean enEjecucion;
    private long tiempoInicio;
    private int minutosRestantes = 3;
    private int segundosRestantes = 0;

    public CronometroDecodificacion(JLabel label) {
        this.labelTiempo = label;
        this.enEjecucion = true;
        this.tiempoInicio = System.currentTimeMillis();
        
        // Iniciar cuenta regresiva
        hiloCronometro = new Thread(() -> {
            while (enEjecucion && (minutosRestantes > 0 || segundosRestantes > 0)) {
                SwingUtilities.invokeLater(() -> {
                    labelTiempo.setText(String.format("Tiempo: %02d:%02d", minutosRestantes, segundosRestantes));
                });
                
                try {
                    Thread.sleep(1000);
                    
                    if (segundosRestantes == 0) {
                        minutosRestantes--;
                        segundosRestantes = 59;
                    } else {
                        segundosRestantes--;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            
            if (enEjecucion) {
                SwingUtilities.invokeLater(() -> {
                    labelTiempo.setText("00:00 - Tiempo agotado");
                });
            }
        });
        
        hiloCronometro.start();
    }
    
    public void detener(String mensajeFinal) {
        enEjecucion = false;
        if (hiloCronometro != null) {
            hiloCronometro.interrupt();
        }
        
        long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;
        SwingUtilities.invokeLater(() -> {
            labelTiempo.setText(String.format("%s (Tiempo: %d.%03d s)", 
                mensajeFinal, 
                tiempoTranscurrido / 1000, 
                tiempoTranscurrido % 1000));
        });
    }
}
// Método mejorado para analizar combinaciones
private void analizarYMostrarCombinaciones(boolean esAdicional) {
    String letras = txtO.getText().replaceAll("[^a-zA-Z]", "").toLowerCase();
    
    if (letras.isEmpty() || letras.length() < 2) {
        if (!esAdicional) {
            jtadescifrado.setText("No hay letras suficientes en txtO para analizar (mínimo 2 letras)");
        }
        return;
    }
    
    // Generar combinaciones posibles con límite de rendimiento
    Set<String> combinacionesUnicas = new HashSet<>();
    generarCombinacionesEficientes(letras, combinacionesUnicas, 6);
    
    // Filtrar y ordenar palabras
    List<String> palabrasValidas = filtrarYOrdenarPalabras(combinacionesUnicas);
    
    // Mostrar resultados
    StringBuilder resultado = new StringBuilder();
    if (esAdicional) {
        resultado.append(jtadescifrado.getText())
                .append("\n\n--- Análisis de letras en txtO ---\n");
    } else {
        resultado.append("--- Análisis de letras en txtO ---\n");
    }
    
    if (palabrasValidas.isEmpty()) {
        resultado.append("No se encontraron palabras reconocidas en: ").append(letras).append("\n");
    } else {
        resultado.append("Letras disponibles: ").append(letras)
                .append("\nPalabras encontradas (").append(palabrasValidas.size()).append("):\n");
        
        // Agrupar por longitud
        Map<Integer, List<String>> palabrasPorLongitud = palabrasValidas.stream()
                .collect(Collectors.groupingBy(String::length));
        
        // Mostrar de mayor a menor longitud
        palabrasPorLongitud.keySet().stream()
                .sorted(Collections.reverseOrder())
                .forEach(longitud -> {
                    resultado.append("\n[").append(longitud).append(" letras]:\n");
                    palabrasPorLongitud.get(longitud).stream()
                            .sorted()
                            .forEach(p -> resultado.append("- ").append(p).append("\n"));
                });
        
        // Mostrar posibles oraciones cortas
        resultado.append("\nPosibles oraciones cortas:\n");
        generarOracionesCortas(palabrasValidas).forEach(oracion -> 
            resultado.append("- ").append(oracion).append("\n"));
    }
    
    if (esAdicional) {
        jtadescifrado.setText(resultado.toString());
    } else {
        jtadescifrado.setText(resultado.toString());
        label1.setText("Análisis completado");
    }
}


private void permutar(String prefijo, String s, Set<String> combinaciones) {
    int n = s.length();
    if (n == 0) {
        if (prefijo.length() >= 2) {
            combinaciones.add(prefijo);
        }
    } else {
        for (int i = 0; i < n; i++) {
            permutar(prefijo + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), combinaciones);
        }
    }
}

private List<String> filtrarYOrdenarPalabras(Set<String> combinaciones) {
    // Diccionario ampliado con más de 500 palabras comunes en español
    Set<String> diccionario = new HashSet<>(Arrays.asList(
        // Sustantivos comunes (200+)
        "agua", "aire", "alma", "alto", "amor", "angel", "año", "arte", "azul", 
        "bajo", "bala", "bebe", "bien", "blanco", "boca", "brazo", "buen", "cabeza", 
        "cafe", "calor", "cama", "cara", "casa", "cielo", "clase", "color", "comida", 
        "corazon", "corte", "costa", "creer", "cruz", "cuadro", "cuerpo", "chico", 
        "dado", "dama", "dedo", "deseo", "dia", "diente", "dios", "dolor", "dulce", 
        "edad", "ejemplo", "elefante", "enero", "espejo", "estrella", "eterno", 
        "fama", "feliz", "flor", "foto", "frase", "fuego", "fuerte", "gato", "golpe", 
        "gracia", "grande", "gris", "grupo", "guerra", "hacha", "hada", "hermano", 
        "hielo", "hijo", "historia", "hombre", "hora", "hotel", "idea", "iglesia", 
        "isla", "jardin", "jefe", "joven", "juego", "jugo", "labio", "lago", "largo", 
        "lente", "libro", "lindo", "lista", "lobo", "loco", "lugar", "luna", "luz", 
        "madre", "maestro", "malo", "mama", "mano", "mapa", "mar", "marea", "mesa", 
        "miedo", "miel", "mirada", "monte", "mundo", "nada", "naranja", "naturaleza", 
        "nave", "nido", "nieve", "noche", "nombre", "norte", "nube", "nuevo", "nunca", 
        "ojo", "olla", "onda", "oro", "oso", "padre", "pais", "pajaro", "pan", "papa", 
        "papel", "parque", "paz", "pecho", "pelicula", "pelo", "perro", "pez", "pie", 
        "piedra", "piel", "piso", "planta", "plata", "playa", "poco", "poder", "poema", 
        "poesia", "pollo", "polo", "pompa", "poner", "premio", "pueblo", "puerta", 
        "pulpo", "punto", "queso", "radio", "rapido", "rato", "rayo", "regalo", "rey", 
        "rio", "risa", "roca", "rojo", "rosa", "rostro", "rueda", "saber", "sabor", 
        "saco", "sal", "sala", "salto", "sangre", "sano", "sarten", "secreto", "sed", 
        "seguir", "sello", "semana", "senor", "sentir", "ser", "serie", "seso", "siglo", 
        "silla", "sirena", "sobre", "sol", "solo", "sonido", "sopa", "sueño", "sur", 
        "taco", "talla", "tapa", "tarde", "taza", "techo", "tecla", "tela", "temor", 
        "templo", "teoria", "tesoro", "tiempo", "tierra", "tigre", "tinta", "tio", 
        "tiza", "tocar", "toldo", "tomate", "tono", "tonto", "torre", "trabajo", 
        "traje", "tren", "tres", "triste", "tronco", "tumba", "uva", "vaca", "vacio", 
        "vago", "valle", "vapor", "vaso", "vecino", "vela", "ventana", "verde", "viaje", 
        "vida", "viejo", "viento", "vino", "violin", "vista", "vivo", "voz", "vuelo", 
        "yate", "yema", "yogur", "zapato", "zona", "zorro",
        
        // Verbos comunes (100+)
        "amar", "andar", "aprender", "ayudar", "bailar", "beber", "buscar", "caer", 
        "cambiar", "cantar", "comer", "comprar", "conocer", "correr", "crear", "creer", 
        "dar", "deber", "decir", "dejar", "desear", "dormir", "empezar", "encontrar", 
        "entender", "escribir", "escuchar", "esperar", "estar", "estudiar", "ganar", 
        "gustar", "hablar", "hacer", "intentar", "ir", "jugar", "leer", "levantar", 
        "limpiar", "llamar", "llegar", "llevar", "lograr", "mirar", "necesitar", "oir", 
        "olvidar", "pagar", "parar", "pasar", "pedir", "pensar", "perder", "poder", 
        "poner", "preguntar", "querer", "recibir", "recordar", "saber", "salir", 
        "seguir", "sentir", "ser", "tener", "terminar", "tocar", "tomar", "trabajar", 
        "traer", "usar", "venir", "ver", "viajar", "vivir", "volver",
        
        // Adjetivos comunes (100+)
        "alto", "bajo", "bueno", "malo", "grande", "pequeño", "joven", "viejo", "nuevo", 
        "viejo", "largo", "corto", "ancho", "estrecho", "fuerte", "debil", "rapido", 
        "lento", "caliente", "frio", "duro", "blando", "pesado", "ligero", "caro", 
        "barato", "bonito", "feo", "limpio", "sucio", "facil", "dificil", "simple", 
        "complejo", "feliz", "triste", "rico", "pobre", "lleno", "vacio", "claro", 
        "oscuro", "dulce", "amargo", "salado", "agrio", "picante", "fresco", "calido", 
        "frio", "humedo", "seco", "suave", "aspero", "liso", "rugoso", "brillante", 
        "opaco", "transparente", "solo", "junto", "cerca", "lejos", "derecho", 
        "izquierdo", "recto", "curvo", "redondo", "cuadrado", "triangular", "ancho", 
        "angosto", "profundo", "superficial", "luminoso", "oscuro", "ruidoso", "silencioso",
        
        // Palabras adicionales (100+)
        "abrir", "acabar", "acceso", "acto", "adulto", "aereo", "afuera", "agenda", 
        "ahora", "alarma", "album", "alerta", "alfabeto", "algo", "algun", "alimento", 
        "almacen", "altura", "amable", "ambiente", "amigo", "ancla", "anillo", "animal", 
        "anoche", "ante", "anuncio", "apagar", "aporte", "apoyo", "aquello", "arbol", 
        "archivo", "arena", "arma", "aroma", "arreglo", "arte", "artista", "asado", 
        "asesino", "asiento", "asistir", "asunto", "ataque", "atencion", "atlas", 
        "atomo", "aula", "aumento", "autobus", "autor", "auxilio", "avance", "avion", 
        "ayer", "ayuda", "azucar", "bacteria", "bahia", "bailarin", "bajo", "bala", 
        "banco", "banda", "banquete", "barco", "barrio", "base", "batalla", "bateria", 
        "batir", "bebida", "bello", "bendicion", "besar", "biblioteca", "bicicleta", 
        "bien", "bigote", "billete", "biologia", "blanco", "blando", "boca", "boda", 
        "bola", "bolsa", "bomba", "bondad", "bosque", "bote", "botella", "bote", "bravo", 
        "breve", "brillo", "broma", "bronce", "brote", "bruja", "bruto", "bucear", 
        "bueno", "bulto", "burbuja", "buscar", "caballo", "cabeza", "cable", "cabo", 
        "cada", "cadena", "caer", "cafe", "caja", "calle", "cama", "camara", "cambio", 
        "camino", "campo", "canal", "cancha", "cancion", "canguro", "canoa", "cansado", 
        "cantar", "capaz", "capital", "capitan", "caracter", "carne", "carrera", 
        "carro", "carta", "casa", "casco", "caso", "castillo", "categoria", "caucho", 
        "causa", "caza", "cebolla", "ceder", "celeste", "celular", "centro", "cerca", 
        "cerdo", "cereza", "cero", "cerrar", "certificado", "cesar", "ciclo", "ciego", 
        "cielo", "ciencia", "cierto", "cifra", "cigarro", "cima", "cine", "circulo", 
        "cirugia", "cita", "ciudad", "civil", "claro", "clase", "clave", "cliente", 
        "clima", "clinica", "club", "cobrar", "cocina", "codigo", "cofre", "coger", 
        "cohete", "colcha", "colegio", "colgar", "colina", "collar", "color", "coma", 
        "comer", "comida", "comite", "como", "comodo", "compania", "compartir", 
        "competir", "completo", "comprar", "comun", "con", "concepto", "concierto", 
        "condicion", "conectar", "confiar", "confuso", "conocer", "consejo", "contar", 
        "contento", "contra", "control", "convencer", "corazon", "coro", "correcto", 
        "cortar", "corto", "cosa", "coser", "cosmos", "costa", "crear", "crecer", 
        "creer", "crimen", "crisis", "cristal", "cruel", "cuadro", "cual", "cuando", 
        "cuarto", "cuatro", "cubrir", "cuchillo", "cuello", "cuenta", "cuerda", 
        "cuerpo", "cuidado", "culpa", "culto", "cumbre", "cumplir", "cuna", "cuento", 
        "cuerda", "cuesta", "cuidar", "culebra", "culpar", "cultivo", "cumpleanos", 
        "cumplir", "cuna", "cuota", "curar", "curioso", "curso", "curva", "cutis", 
        "dama", "danza", "dar", "dato", "deber", "decir", "dedo", "defender", "dejar", 
        "delfin", "delgado", "demanda", "demonio", "dentro", "deposito", "derecho", 
        "desayuno", "descanso", "desear", "desfile", "desierto", "despues", "destino", 
        "detalle", "detener", "deuda", "dia", "diablo", "diamante", "dibujo", "diente", 
        "dieta", "diferente", "dificil", "dinero", "dios", "directo", "disco", "disfraz", 
        "disparo", "diversion", "divertido", "doble", "doce", "doctor", "documento", 
        "dolor", "domingo", "donde", "dormir", "dosis", "drama", "droga", "ducha", 
        "duda", "dueno", "duro", "ebrio", "eco", "edad", "edificio", "educacion", 
        "efecto", "ejemplo", "elefante", "elegir", "elemento", "elevar", "elite", 
        "ella", "embajada", "empezar", "empresa", "enano", "encender", "encontrar", 
        "energia", "enfermo", "engaño", "enorme", "ensayo", "entender", "entero", 
        "entrada", "enviar", "equipo", "error", "escala", "escena", "esclavo", 
        "escribir", "escuela", "esfera", "esfuerzo", "espacio", "espejo", "esposo", 
        "esta", "estadio", "estado", "estatua", "este", "estilo", "estreno", "etapa", 
        "eterno", "europa", "evitar", "exacto", "examen", "exceso", "exigir", "exito", 
        "experto", "explicar", "explorar", "exportar", "expresar", "extrano", "fabrica", 
        "facil", "factura", "faena", "faja", "falda", "falso", "fama", "familia", 
        "famoso", "farmacia", "favor", "febrero", "fecha", "feliz", "feo", "feria", 
        "feroz", "fiesta", "figura", "fijar", "fila", "filo", "filosofia", "fin", 
        "finca", "firma", "flaco", "flor", "flujo", "foco", "fogata", "folleto", 
        "fondo", "forma", "fortaleza", "forzar", "foto", "fracaso", "francia", 
        "frasco", "frecuente", "freno", "frente", "fruta", "fuego", "fuente", 
        "fuerza", "fuga", "fumar", "funcion", "funda", "futuro", "gafas", "gaita", 
        "galaxia", "galeria", "gallo", "ganar", "garganta", "gasolina", "gastar", 
        "gato", "gemelo", "genero", "genio", "gente", "gestion", "gigante", "girar", 
        "globo", "gloria", "golpe", "goma", "gordo", "gorra", "gota", "gozar", 
        "grado", "gramo", "gran", "grande", "grano", "grasa", "grave", "gris", 
        "gritar", "grupo", "guante", "guapo", "guardar", "guerra", "guia", "guion", 
        "gusano", "gustar", "haber", "habito", "hablar", "hacer", "hacha", "hallar", 
        "hambre", "harina", "hasta", "hato", "haya", "hecho", "helado", "herida", 
        "hermano", "heroe", "hervir", "hielo", "hierro", "higo", "hijo", "himno", 
        "historia", "hocico", "hogar", "hoja", "hombre", "hondo", "honesto", "hora", 
        "hotel", "hoyo", "hueco", "huevo", "huir", "humano", "humo", "ida", "ideal", 
        "iglesia", "igual", "ilegal", "imagen", "imitar", "imperio", "importar", 
        "impulso", "incendio", "incluir", "indice", "inerte", "infiel", "informe", 
        "ingenio", "inicio", "inmenso", "insecto", "instante", "interes", "invierno", 
        "invitar", "ir", "isla", "izquierda", "jabon", "jamas", "jardin", "jarra", 
        "jaula", "jefe", "jersey", "jinete", "joven", "joya", "juego", "julio", 
        "jungla", "juntar", "jurado", "justo", "juzgar", "kilo", "koala", "labio", 
        "lado", "ladron", "lagrima", "lago", "lamer", "lana", "lancha", "lanzar", 
        "lapiz", "largo", "lata", "lavar", "lazo", "leal", "leccion", "leche", 
        "lector", "leer", "legumbre", "lejano", "lengua", "lento", "leon", "letra", 
        "levar", "ley", "libertad", "libro", "licor", "lider", "liga", "limite", 
        "limpio", "lindo", "linea", "liquido", "lista", "litera", "llave", "llegar", 
        "llenar", "llevar", "llorar", "llover", "lluvia", "lobo", "local", "loco", 
        "lograr", "lomo", "lona", "lote", "lucha", "luego", "lugar", "lujo", "luna", 
        "lunes", "luz", "maceta", "madera", "madre", "maestro", "mafia", "magia", 
        "mago", "maiz", "maleta", "mama", "manda", "mango", "mano", "manso", "manta", 
        "manzana", "mapa", "maquina","hola", "mar", "marco", "marea", "marido", "marrón", 
        "martes", "marzo", "masa", "matar", "materia", "matriz", "mayo", "mayor", 
        "mecanico", "medalla", "medio", "mejor", "melón", "memoria", "menor", "mensaje", 
        "mente", "menu", "mercado", "mercurio", "mes", "mesa", "metal", "metro", 
        "mexico", "mi", "micro", "miedo", "miel", "miembro", "milla", "millon", 
        "mina", "minuto", "mirada", "mismo", "mitad", "modelo", "moho", "mojar", 
        "molde", "molino", "momento", "moneda", "mono", "montaña", "moral", "moreno", 
        "morir", "mosca", "mostrar", "motivo", "mover", "mucho", "mudar", "mueble", 
        "muela", "muerte", "muestra", "mujer", "mula", "multa", "mundo", "muñeca", 
        "muro", "musica", "nacer", "nada", "nadie", "naipe", "naranja", "nariz", 
        "nata", "navaja", "nave", "necio", "negar", "negro", "nervio", "neto", 
        "neutro", "nevar", "nido", "niebla", "nieto", "nieve", "nino", "nivel", 
        "noble", "noche", "nombre", "norte", "nota", "novela", "novio", "nube", 
        "nuca", "nuevo", "numero", "nutria", "oasis", "objeto", "obra", "obtener", 
        "ocaso", "oceano", "ocho", "ocio", "octubre", "oculto", "ocupar", "ocurrir", 
        "odiar", "odio", "oeste", "ofensa", "oferta", "oficina", "ofrecer", "oido", 
        "oir", "ojo", "ola", "oleada", "olfato", "olivo", "olvido", "ombligo", 
        "onda", "opaco", "opcion", "opera", "opinar", "oponer", "optar", "oracion", 
        "orden", "oreja", "organo", "orgullo", "origen", "oro", "orquesta", "oscuro", 
        "oso", "ostra", "otoño", "otro", "oveja", "oxido", "oye", "pacto", "padre", 
        "pagar", "pais", "pajaro", "palabra", "palco", "palma", "pan", "panal", 
        "panico", "pantalla", "pantera", "panuelo", "papa", "papel", "par", "parar", 
        "parcela", "pared", "pareja", "parir", "paro", "parte", "pasar", "paseo", 
        "paso", "pasta", "pata", "patio", "patria", "pausa", "pauta", "paz", "peaje", 
        "peaton", "pecado", "pecho", "pedal", "pedir", "pegar", "peine", "pelar", 
        "pelicula", "pelo", "pelota", "pena", "pensar", "peon", "peor", "pepino", 
        "pequeño", "pera", "perder", "perdon", "perfil", "perico", "perla", "perro", 
        "persona", "pesar", "pesca", "peso", "pestana", "petroleo", "pez", "picar", 
        "pie", "piedra", "pierna", "pieza", "pijama", "pila", "piloto", "pimienta", 
        "pino", "pintar", "pinza", "piojo", "pipa", "pirata", "pisar", "piscina", 
        "piso", "pista", "piton", "pizca", "placa", "plan", "planta", "plata", 
        "playa", "plaza", "plomo", "pluma", "pobre", "poco", "poder", "poema", 
        "poesia", "pollo", "polo", "polvo", "pomada", "pomelo", "pomo", "pompa", 
        "poner", "porcion", "portal", "posada", "poste", "potro", "pozo", "prado", 
        "premio", "prensa", "preso", "previo", "primo", "principe", "prisa", "proa", 
        "probar", "proceso", "producto", "profeta", "programa", "prole", "promesa", 
        "pronto", "propio", "prosa", "proteina", "provecho", "prueba", "publico", 
        "pueblo", "puerta", "puesto", "pulga", "pulir", "pulmon", "pulpo", "pulso", 
        "puma", "punto", "puño", "puro", "quedar", "queja", "quemar", "querer", 
        "queso", "quieto", "quimica", "quince", "quitar", "rabia", "rabo", "racimo", 
        "racion", "radar", "radio", "raiz", "rama", "rampa", "rancho", "rango", 
        "rapido", "raro", "rata", "rayo", "raza", "razon", "reaccion", "real", 
        "rebanada", "rebote", "recado", "receptor", "receta", "rechazar", "recibo", 
        "recoger", "recreo", "recto", "recuerdo", "red", "redondo", "reducir", 
        "reflejo", "reforma", "refran", "regalo", "regla", "reina", "reir", 
        "relacion", "relampago", "reloj", "remar", "remedio", "remo", "rencor", 
        "rendir", "renta", "reparto", "repetir", "reposo", "resina", "respeto", 
        "resto", "retiro", "retrato", "reunion", "revista", "rey", "rezar", "rico", 
        "riego", "rienda", "riesgo", "rifa", "rigido", "rincón", "riña", "rio", 
        "riqueza", "risa", "ritmo", "rito", "rival", "robar", "roble", "roce", 
        "rocio", "rodar", "rodilla", "roer", "rojo", "rol", "romano", "romper", 
        "ron", "roncar", "ronda", "ropa", "rosa", "rostro", "rotar", "rubi", 
        "rubor", "rudo", "rueda", "rugir", "ruido", "ruina", "ruta", "rutina", 
        "saber", "sabio", "sable", "sacar", "sacerdote", "saco", "sacudir", "sagrado", 
        "sala", "saldo", "salida", "salmon", "salon", "salto", "salud", "salvar", 
        "sanar", "sancion", "sandia", "sangre", "sanidad", "sano", "santo", "sapo", 
        "saque", "sarten", "satelite", "satisfacer", "sauce", "savia", "sazon", 
        "secar", "seco", "secreto", "sector", "sed", "seguir", "seguro", "seis", 
        "sello", "selva", "semana", "semilla", "senal", "sencillo", "seno", "sensacion", 
        "sentir", "senal", "separar", "sepia", "sequia", "ser", "serie", "serio", 
        "sermon", "servir", "sesenta", "seso", "seta", "setenta", "severo", "sexo", 
        "sexto", "sidra", "siempre", "siete", "siglo", "signo", "silencio", "silla", 
        "simbolo", "simple", "sin", "sincero", "sintoma", "sirviente", "sistema", 
        "sitio", "situar", "sobre", "sociedad", "sofá", "sol", "soldado", "solo", 
        "soltar", "solucion", "sombra", "sombrero", "sonar", "sonido", "sonreir", 
        "sonrisa", "sopa", "soplar", "soporte", "sordo", "sorpresa", "sorteo", 
        "sostener", "sota", "suave", "subir", "sucio", "sudor", "suegra", "suelo", 
        "sueno", "suerte", "sufrir", "sujetar", "sultán", "sumar", "superar", 
        "suplicio", "suponer", "sur", "surgir", "susto", "sutil", "tabaco", "tabla", 
        "taco", "tacto", "tahúr", "tajo", "tal", "talento", "talla", "talle", 
        "talo", "tambor", "tango", "tanque", "tapa", "tapia", "tapón", "taquilla", 
        "tarde", "tarea", "tarifa", "tarjeta", "tarro", "tarta", "tasar", "tatuaje", 
        "taxi", "taza", "teatro", "techo", "tecla", "tejado", "tejer", "tela", 
        "telefono", "tema", "temblar", "temor", "templo", "tenaz", "tender", 
        "tener", "tenis", "tenso", "teoria", "tercio", "termino", "ternura", 
        "terreno", "terror", "tesoro", "testigo", "tetera", "texto", "tez", 
        "tibio", "tiempo", "tienda", "tierra", "tieso", "tigre", "tijera", 
        "tila", "timbre", "timo", "tintero", "tio", "tipo", "tirar", "titulo", 
        "tiza", "toalla", "tobillo", "tocar", "tocino", "todo", "toldo", 
        "tomar", "tonelada", "tono", "tonto", "topar", "toque", "torbellino", 
        "torcer", "torear", "tormenta", "torneo", "toro", "torpe", "torre", 
        "torso", "tortuga", "tos", "toser", "tostar", "trabajo", "traer", 
        "trafico", "trago", "traje", "tramo", "trampa", "tranquilo", "transporte", 
        "trapo", "tratar", "treinta", "tren", "trepar", "tres", "tribu", 
        "trigo", "tripa", "triste", "triunfo", "trofeo", "trompeta", "tronco", 
        "tropa", "trotar", "trozo", "truco", "trueno", "tu", "tubo", "tumba", 
        "tumor", "tunel", "turismo", "turno", "tutor", "ubicar", "ultimo", 
        "unico", "unidad", "unir", "universo", "uno", "untar", "uña", "urbano", 
        "urgencia", "usar", "uso", "usted", "utensilio", "util", "uva", "vaca", 
        "vacío", "vacuna", "vagar", "vago", "vaina", "vajilla", "vale", 
        "valiente", "valle", "valor", "vapor", "vara", "variar", "vaso", 
        "vecino", "vegetal", "vehiculo", "veinte", "vejez", "vela", "velero", 
        "velo", "veloz", "vena", "vencer", "venda", "vender", "venir", 
        "ventana", "ventura", "ver", "verano", "verbo", "verdad", "verde", 
        "vereda", "verja", "verso", "verter", "vestido", "veterano", "vez", 
        "viaje", "vibrar", "vicio", "victima", "vida", "video", "viejo", 
        "viento", "viernes", "vigor", "vil", "villa", "vinagre", "vino", 
        "violencia", "violeta", "violin", "viral", "virgen", "virtud", 
        "visita", "vista", "vitamina", "viudo", "vivo", "vocablo", "volar", 
        "volcan", "volumen", "volver", "vomitar", "voto", "voz", "vuelo", 
        "vuelta", "vulgar", "yacer", "yate", "yegua", "yema", "yerno", 
        "yeso", "yodo", "yogur", "yunque", "yugo", "yunta", "zafiro", 
        "zambo", "zapato", "zarza", "zona", "zorro", "zumo", "zurdo"
    ));
    
    return combinaciones.stream()
            .filter(p -> diccionario.contains(p.toLowerCase()))
            .sorted(Comparator.comparing(String::length).reversed()
                .thenComparing(Comparator.naturalOrder()))
            .collect(Collectors.toList());
}
// Método mejorado para generar oraciones cortas
private List<String> generarOracionesCortas(List<String> palabras) {
    List<String> oraciones = new ArrayList<>();
    
    // Combinaciones artículo + sustantivo
    List<String> articulos = Arrays.asList("el", "la", "un", "una", "los", "las", "unos", "unas");
    List<String> sustantivos = palabras.stream()
            .filter(p -> p.length() >= 3)
            .collect(Collectors.toList());
    
    for (String articulo : articulos) {
        for (String sustantivo : sustantivos) {
            if (combinacionValida(articulo, sustantivo)) {
                oraciones.add(articulo + " " + sustantivo);
            }
        }
    }
    
    // Combinaciones sujeto + verbo
    List<String> sujetos = Arrays.asList("yo", "tu", "el", "ella", "nosotros", "vosotros", "ellos");
    List<String> verbos = Arrays.asList(
            "soy", "eres", "es", "somos", "sois", "son", "tengo", "tienes", "tiene", 
            "tenemos", "teneis", "tienen", "quiero", "quieres", "quiere", "podemos"
    );
    
    for (String sujeto : sujetos) {
        for (String verbo : verbos) {
            if (palabras.contains(verbo)) {
                oraciones.add(sujeto + " " + verbo);
            }
        }
    }
    
    // Combinaciones verbo + complemento
    List<String> complementos = palabras.stream()
            .filter(p -> p.length() >= 3)
            .collect(Collectors.toList());
    
    for (String verbo : verbos) {
        for (String complemento : complementos) {
            if (palabras.contains(verbo) && !verbo.equals(complemento)) {
                oraciones.add(verbo + " " + complemento);
            }
        }
    }
    
    return oraciones.stream()
            .distinct()
            .limit(10)
            .collect(Collectors.toList());
}

private boolean combinacionValida(String articulo, String sustantivo) {
    // Reglas básicas de concordancia género/número
    if (articulo.equals("el") && sustantivo.endsWith("a")) return false;
    if (articulo.equals("la") && sustantivo.endsWith("o")) return false;
    if (articulo.equals("los") && !sustantivo.endsWith("s")) return false;
    if (articulo.equals("las") && !sustantivo.endsWith("s")) return false;
    
    return true;
}

private void generarCombinacionesEficientes(String letras, Set<String> combinaciones, int maxLongitud) {
    if (letras == null || letras.isEmpty() || maxLongitud < 2) return;

    // Convertir a minúsculas y eliminar caracteres duplicados
    String letrasUnicas = letras.toLowerCase().chars()
            .distinct()
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

    // Generar permutaciones de longitud 2 hasta maxLongitud
    for (int len = 2; len <= Math.min(maxLongitud, letrasUnicas.length()); len++) {
        permutaciones(letrasUnicas, "", len, combinaciones);
    }

    // Agregar subcadenas consecutivas de la entrada original (no letrasUnicas)
    letras = letras.toLowerCase();
    for (int i = 0; i < letras.length(); i++) {
        for (int j = i + 2; j <= Math.min(letras.length(), i + maxLongitud); j++) {
            combinaciones.add(letras.substring(i, j));
        }
    }
}

private void permutaciones(String letras, String prefijo, int len, Set<String> combinaciones) {
    if (prefijo.length() == len) {
        combinaciones.add(prefijo);
        return;
    }

    for (int i = 0; i < letras.length(); i++) {
        permutaciones(letras, prefijo + letras.charAt(i), len, combinaciones);
    }
}


// [Mantener los demás métodos igual: consultarMensajeDeBD, decodificarPalabra, etc.]
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

    private void analizarLetrasTxtO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String decodificarConArbol(String mensajeCifrado, ArbolBinario arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private void txttiempoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txttiempoAncestorAdded
        JLabel Iblcrrnometro = null;
        cronometro cronometro = new cronometro (Iblcrrnometro);
       

    }//GEN-LAST:event_txttiempoAncestorAdded

    private void txtcontadorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtcontadorAncestorAdded

    }//GEN-LAST:event_txtcontadorAncestorAdded

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
    private javax.swing.JLabel txttiempo;
    // End of variables declaration//GEN-END:variables
}
