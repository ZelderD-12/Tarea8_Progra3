package arbol;

public class Nodo {
    private int dato;       // Valor numérico de la letra (a=1, b=2,...)
    private Nodo izq;       // Hijo izquierdo
    private Nodo der;       // Hijo derecho
    private int altura;     // Altura del nodo

    public Nodo(int dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
        this.altura = 1;
    }

    // Getters y setters
    public int getDato() {
        return dato;
    }


    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public char getLetra() {
    return LetraUtils.numeroALetra(this.dato);
    }

}