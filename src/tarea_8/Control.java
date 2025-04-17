package tarea_8;

import arbol.ArbolBB;
import arbol.ArbolExpresionGrafico;
import arbol.LetraUtils;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Control {
    private final ArbolBB arbol; 
    private final JScrollPane scrollPane;
    private final JPanel panel;
    private final JTextArea textArea;

    public Control(JScrollPane scrollPane, JPanel panel, JTextArea textArea) {
        this.arbol = new ArbolBB(); // ArbolBB inicializado correctamente
        this.scrollPane = scrollPane;
        this.panel = panel;
        this.textArea = textArea;
    }

    public boolean insertar(String letra) {
        if (!LetraUtils.esLetraValida(letra)) {
            System.out.println("Error: Ingrese una sola letra minúscula (a-z)");
            return false;
        }

        char c = letra.toLowerCase().charAt(0);
        arbol.agregarLetra(c);
        actualizarVista();
        return true;
    }

    public boolean eliminar(String letra) {
        if (!LetraUtils.esLetraValida(letra)) {
            System.out.println("Error: Ingrese una sola letra minúscula (a-z)");
            return false;
        }

        char c = letra.toLowerCase().charAt(0);
        boolean eliminado = arbol.eliminarLetra(c);
        
        if (eliminado) {
            System.out.println("Letra '" + c + "' eliminada");
            actualizarVista();
        } else {
            System.out.println("Letra '" + c + "' no encontrada");
        }
        
        return eliminado;
    }

    public String buscar(String letra) {
    if (!LetraUtils.esLetraValida(letra)) {
        return "Error: Ingrese una sola letra minúscula (a-z)";
    }

    char c = letra.toLowerCase().charAt(0);
    boolean existe = arbol.existeLetra(c);

    if (existe) {
        return "Letra '" + c + "' encontrada";
    } else {
        return "Letra '" + c + "' no encontrada";
    }
}


    public void mostrarRecorridos() {
        SwingUtilities.invokeLater(() -> {
            textArea.append("\n=== Recorridos del Árbol ===\n");
            textArea.append("PreOrden:  " + listarRecorrido(arbol.preOrdenLetras()) + "\n");
            textArea.append("InOrden:   " + listarRecorrido(arbol.inOrdenLetras()) + "\n");
            textArea.append("PostOrden: " + listarRecorrido(arbol.postOrdenLetras()) + "\n");
        });
    }

    private String listarRecorrido(LinkedList<Character> recorrido) {
        StringBuilder sb = new StringBuilder();
        for (Character letra : recorrido) {
            sb.append(letra).append(" ");
        }
        return sb.toString();
    }

    private void actualizarVista() {
        SwingUtilities.invokeLater(() -> {
            panel.removeAll();
            ArbolExpresionGrafico dibujo = new ArbolExpresionGrafico(arbol, scrollPane, panel);
            panel.add(dibujo);
            panel.revalidate();
            panel.repaint();
            
            // Asegurar que el scrollPane muestra el panel actualizado
            scrollPane.setViewportView(panel);
            scrollPane.revalidate();
            scrollPane.repaint();
        });
    }

    private void mostrarMensaje(String mensaje) {
        SwingUtilities.invokeLater(() -> {
            textArea.append(mensaje + "\n");
        });
    }
    public void borrarArbol() {
        arbol.borrarArbol(); // Llama al método borrarArbol de la clase ArbolBB
        actualizarVista(); 
        System.out.println("Arbol borrado correctamente");
    }
}
