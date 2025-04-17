package arbol;

import java.util.LinkedList;
import javax.swing.*;


public class SimuladorArbolBinario {

    private ArbolBB miArbol;

    public SimuladorArbolBinario() {
        this.miArbol = new ArbolBB();
    }

    public boolean estaVacio() {
        return this.miArbol.estaVacio();
    }

    public boolean insertar(Character letra) {
        if (letra == null) {
            throw new IllegalArgumentException("La letra no puede ser nula.");
        }
        return this.miArbol.agregarLetra(letra);
    }

    public boolean insertarPrimero(Character letra1, Character letra2) {
        if (letra1 == null || letra2 == null) {
            throw new IllegalArgumentException("Las letras no pueden ser nulas.");
        }
        boolean insertado = this.miArbol.agregarLetra(letra1);
        if (insertado) {
            insertado = this.miArbol.agregarLetra(letra2);
        }
        return insertado;
    }

    public boolean eliminar(Character letra) {
        if (letra == null) {
            throw new IllegalArgumentException("La letra no puede ser nula.");
        }
        return this.miArbol.eliminarLetra(letra);
    }

    public void borrarArbol() {
        this.miArbol.borrarArbol();
    }

    public String preOrden() {
        LinkedList<Character> it = this.miArbol.preOrdenLetras();
        return recorridoLetras(it, "Recorrido PreOrden:");
    }

    public String inOrden() {
        LinkedList<Character> it = this.miArbol.inOrdenLetras();
        return recorridoLetras(it, "Recorrido InOrden:");
    }

    public String postOrden() {
        LinkedList<Character> it = this.miArbol.postOrdenLetras();
        return recorridoLetras(it, "Recorrido PostOrden:");
    }

    private String recorridoLetras(LinkedList<Character> it, String msg) {
        StringBuilder r = new StringBuilder(msg + "\n");
        for (Character letra : it) {
            r.append("\t").append(letra).append("\n");
        }
        return r.toString();
    }

    public String buscar(Character letra) {
        if (letra == null) {
            throw new IllegalArgumentException("La letra no puede ser nula.");
        }
        boolean siEsta = this.miArbol.existeLetra(letra);
        return "La letra: " + letra + "\n" +
               (siEsta ? "Sí se encuentra en el árbol" : "No se encuentra en el árbol");
    }

    public boolean buscarNumero(Character letra) {
        if (letra == null) {
            throw new IllegalArgumentException("La letra no puede ser nula.");
        }
        return this.miArbol.existeLetra(letra);
    }

    public JPanel getDibujo(JScrollPane scrollPane, JPanel panel) {
        if (scrollPane == null || panel == null) {
            throw new IllegalArgumentException("El JScrollPane o el JPanel no pueden ser nulos.");
        }
        return this.miArbol.getDibujo(scrollPane, panel);
    }

    public void repintarArbol(JPanel panel) {
        if (panel == null) {
            throw new IllegalArgumentException("El JPanel no puede ser nulo.");
        }
        this.miArbol.repintar(panel);
    }

    public int obtenerTamanioArbol() {
        return this.miArbol.obtenerTamanio();
    }
}
