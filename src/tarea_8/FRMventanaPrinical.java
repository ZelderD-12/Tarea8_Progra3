package tarea_8;

import dbconnection.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FRMventanaPrinical extends javax.swing.JFrame {

    Control controlador;

    public FRMventanaPrinical() {
        initComponents();
        controlador = new Control(scrolArbol, paneldelArbol, txtFrase);
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 430, 110));

        jbtnsave.setText("Guardar en DB");
        jbtnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, 150, 40));

        jbtnconn.setText("Conectar DB");
        jbtnconn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnconnActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnconn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 160, 40));

        jtadescifrado.setColumns(20);
        jtadescifrado.setRows(5);
        jScrollPane3.setViewportView(jtadescifrado);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 430, 150));

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

    private void btnArmarArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArmarArbolActionPerformed
        String letra = txtFrase.getText();
        controlador.insertar(letra);

    }//GEN-LAST:event_btnArmarArbolActionPerformed

    private void jbtnconnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnconnActionPerformed
        // TODO add your handling code here:
        dbconn.cargarDatosEnTabla(jtblMensaje, this);
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
