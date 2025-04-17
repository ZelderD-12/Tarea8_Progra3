package arbol;

public class BusquedaResultado {
    private boolean encontrado;
    private int pasos;
    
    public BusquedaResultado(boolean encontrado, int pasos) {
        this.encontrado = encontrado;
        this.pasos = pasos;
    }
    
    public boolean isEncontrado() { return encontrado; }
    public int getPasos() { return pasos; }
}