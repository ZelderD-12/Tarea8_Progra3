/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_8;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
 import javax.swing.JLabel;
import javax.swing.SwingUtilities;
/**
 *
 * @author HP15C0008LA
 */
class cronometro {
   
    private JLabel label;
    private Thread hiloCronometro;
    private boolean enEjecucion;

    public cronometro(JLabel label) {
        this.label = label;
        this.enEjecucion = true;
        
        hiloCronometro = new Thread(() -> {
            int minutos = 3;
            int segundos = 0;
            
            while (enEjecucion && (minutos > 0 || segundos > 0)) {
                // Variables finales para usar en el lambda
                final int min = minutos;
                final int seg = segundos;
                
                // Actualizar el label en el hilo de eventos de Swing
                SwingUtilities.invokeLater(() -> {
                    label.setText(String.format("%02d:%02d", min, seg));
                });
                
                try {
                    Thread.sleep(1000); // Esperar 1 segundo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                
                if (segundos == 0) {
                    minutos--;
                    segundos = 59;
                } else {
                    segundos--;
                }
            }
            
            // Cuando termina el tiempo
            if (enEjecucion) {
                SwingUtilities.invokeLater(() -> {
                    label.setText("¡Ya terminó la función!");
                });
            }
        });
        
        hiloCronometro.start();
    }
    
    public void detener() {
        enEjecucion = false;
        hiloCronometro.interrupt();
    }
}
