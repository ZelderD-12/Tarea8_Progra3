package arbol;

import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ArbolBB {
    protected Nodo raiz;

    public ArbolBB() {
        raiz = null;
    }

    // Métodos básicos
    public boolean estaVacio() {
        return raiz == null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    // Métodos modificados para no balancear
    public boolean agregarLetra(char letra) {
        int dato = LetraUtils.letraANumero(letra);
        raiz = insertarNoBalanceado(raiz, dato);
        return true;
    }

    private Nodo insertarNoBalanceado(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }

        // Permitir duplicados insertándolos a la izquierda
        if (dato <= nodo.getDato()) {
            nodo.setIzq(insertarNoBalanceado(nodo.getIzq(), dato));
        } else {
            nodo.setDer(insertarNoBalanceado(nodo.getDer(), dato));
        }
        
        return nodo; // Sin balanceo
    }

    public boolean eliminarLetra(char letra) {
        int dato = LetraUtils.letraANumero(letra);
        raiz = eliminarNoBalanceado(raiz, dato);
        return true;
    }

    private Nodo eliminarNoBalanceado(Nodo nodo, int dato) {
        if (nodo == null) {
            return null;
        }

        if (dato < nodo.getDato()) {
            nodo.setIzq(eliminarNoBalanceado(nodo.getIzq(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setDer(eliminarNoBalanceado(nodo.getDer(), dato));
        } else {
            if (nodo.getIzq() == null) {
                return nodo.getDer();
            } else if (nodo.getDer() == null) {
                return nodo.getIzq();
            }
            
            Nodo temp = encontrarMinimo(nodo.getDer());
            nodo.setDato(temp.getDato());
            nodo.setDer(eliminarNoBalanceado(nodo.getDer(), temp.getDato()));
        }
        
        return nodo; // Sin balanceo
    }
    private Nodo encontrarMinimo(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.getIzq() != null) {
            actual = actual.getIzq();
        }
        return actual;
    }

    public boolean existeLetra(char letra) {
        int dato = LetraUtils.letraANumero(letra);
        return buscarRecursivo(raiz, dato);
    }

    public LinkedList<Character> preOrdenLetras() {
        LinkedList<Character> recorrido = new LinkedList<>();
        preOrdenRecursivo(raiz, recorrido);
        return recorrido;
    }

    private void preOrdenRecursivo(Nodo nodo, LinkedList<Character> recorrido) {
        if (nodo != null) {
            // 1. Visitar la raíz
            recorrido.add(nodo.getLetra());
            
            // 2. Recorrer subárbol izquierdo
            preOrdenRecursivo(nodo.getIzq(), recorrido);
            
            // 3. Recorrer subárbol derecho
            preOrdenRecursivo(nodo.getDer(), recorrido);
        }
    }

    public LinkedList<Character> inOrdenLetras() {
        LinkedList<Character> rec = new LinkedList<>();
        inordenLetras(raiz, rec);
        return rec;
    }

    private void inordenLetras(Nodo nodo, LinkedList<Character> recorrido) {
        if (nodo != null) {
            inordenLetras(nodo.getIzq(), recorrido);
            recorrido.add(nodo.getLetra());
            inordenLetras(nodo.getDer(), recorrido);
        }
    }

    public LinkedList<Character> postOrdenLetras() {
        LinkedList<Character> rec = new LinkedList<>();
        postordenLetras(raiz, rec);
        return rec;
    }

    private void postordenLetras(Nodo nodo, LinkedList<Character> recorrido) {
        if (nodo != null) {
            postordenLetras(nodo.getIzq(), recorrido);
            postordenLetras(nodo.getDer(), recorrido);
            recorrido.add(nodo.getLetra());
        }
    }

    // Métodos de balanceo y operaciones básicas
    private int altura(Nodo nodo) {
        return nodo == null ? 0 : nodo.getAltura();
    }

    private int getBalance(Nodo nodo) {
        return nodo == null ? 0 : altura(nodo.getIzq()) - altura(nodo.getDer());
    }

    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.getIzq();
        Nodo T2 = x.getDer();

        x.setDer(y);
        y.setIzq(T2);

        y.setAltura(Math.max(altura(y.getIzq()), altura(y.getDer())) + 1);
        x.setAltura(Math.max(altura(x.getIzq()), altura(x.getDer())) + 1);

        return x;
    }

    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.getDer();
        Nodo T2 = y.getIzq();

        y.setIzq(x);
        x.setDer(T2);

        x.setAltura(Math.max(altura(x.getIzq()), altura(x.getDer())) + 1);
        y.setAltura(Math.max(altura(y.getIzq()), altura(y.getDer())) + 1);

        return y;
    }

    private Nodo insertarBalanceado(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }

        // Modificación: Permitir duplicados insertándolos a la izquierda
        if (dato <= nodo.getDato()) {  // Cambio de < a <=
            nodo.setIzq(insertarBalanceado(nodo.getIzq(), dato));
        } else {
            nodo.setDer(insertarBalanceado(nodo.getDer(), dato));
        }

        // Resto del método de balanceo permanece igual
        nodo.setAltura(1 + Math.max(altura(nodo.getIzq()), altura(nodo.getDer())));

        int balance = getBalance(nodo);

        // Casos de rotación (sin cambios)
        if (balance > 1 && dato <= nodo.getIzq().getDato()) {
            return rotarDerecha(nodo);
        }
        if (balance < -1 && dato > nodo.getDer().getDato()) {
            return rotarIzquierda(nodo);
        }
        if (balance > 1 && dato > nodo.getIzq().getDato()) {
            nodo.setIzq(rotarIzquierda(nodo.getIzq()));
            return rotarDerecha(nodo);
        }
        if (balance < -1 && dato < nodo.getDer().getDato()) {
            nodo.setDer(rotarDerecha(nodo.getDer()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private Nodo eliminarBalanceado(Nodo nodo, int dato) {
        if (nodo == null) {
            return nodo;
        }

        if (dato < nodo.getDato()) {
            nodo.setIzq(eliminarBalanceado(nodo.getIzq(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setDer(eliminarBalanceado(nodo.getDer(), dato));
        } else {
            if (nodo.getIzq() == null || nodo.getDer() == null) {
                Nodo temp = (nodo.getIzq() != null) ? nodo.getIzq() : nodo.getDer();
                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else {
                    nodo = temp;
                }
            } else {
                Nodo temp = encontrarMinimo(nodo.getDer());
                nodo.setDato(temp.getDato());
                nodo.setDer(eliminarBalanceado(nodo.getDer(), temp.getDato()));
            }
        }

        if (nodo == null) {
            return nodo;
        }

        nodo.setAltura(1 + Math.max(altura(nodo.getIzq()), altura(nodo.getDer())));

        int balance = getBalance(nodo);

        // Balancear el árbol
        if (balance > 1 && getBalance(nodo.getIzq()) >= 0) {
            return rotarDerecha(nodo);
        }
        if (balance > 1 && getBalance(nodo.getIzq()) < 0) {
            nodo.setIzq(rotarIzquierda(nodo.getIzq()));
            return rotarDerecha(nodo);
        }
        if (balance < -1 && getBalance(nodo.getDer()) <= 0) {
            return rotarIzquierda(nodo);
        }
        if (balance < -1 && getBalance(nodo.getDer()) > 0) {
            nodo.setDer(rotarDerecha(nodo.getDer()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private boolean buscarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) {
            return false;
        }
        if (dato == nodo.getDato()) {
            return true;
        }
        return dato < nodo.getDato() ? 
               buscarRecursivo(nodo.getIzq(), dato) : 
               buscarRecursivo(nodo.getDer(), dato);
    }

    public ArbolExpresionGrafico getDibujo(JScrollPane scrollPane, JPanel panel) {
    return new ArbolExpresionGrafico(this, scrollPane, panel);
    }

    public void repintar(JPanel panel) {
    panel.removeAll();
    ArbolExpresionGrafico dibujo = new ArbolExpresionGrafico(this, 
        (JScrollPane)panel.getParent(), panel);
    panel.add(dibujo);
    panel.revalidate();
    panel.repaint();
    }
    
    public void borrarArbol() {
    raiz = null; // Esto eliminará todas las referencias y el GC se encargará del resto
    }
    public int obtenerTamanio() {
    return obtenerTamanio(raiz);
}

private int obtenerTamanio(Nodo nodo) {
    if (nodo == null) {
        return 0;
    }
    return 1 + obtenerTamanio(nodo.getIzq()) + obtenerTamanio(nodo.getDer());
}

    
}