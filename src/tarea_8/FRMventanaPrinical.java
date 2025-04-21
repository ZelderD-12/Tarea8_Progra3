package tarea_8;

import dbconnection.*;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FRMventanaPrinical extends javax.swing.JFrame {
    private JComboBox<String> comboNombres;
    public String Nombre;
    public String ID; 
    private TXT gestorTXT = new TXT(); 
    
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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 430, 150));

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnconn;
    private javax.swing.JButton jbtnsave;
    private javax.swing.JTextArea jtadescifrado;
    private javax.swing.JTable jtblMensaje;
    private javax.swing.JPanel paneldelArbol;
    private javax.swing.JScrollPane scrolArbol;
    private javax.swing.JTextArea txtFrase;
    // End of variables declaration//GEN-END:variables
}
