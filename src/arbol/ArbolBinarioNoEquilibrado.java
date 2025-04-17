package arbol;

public class ArbolBinarioNoEquilibrado extends ArbolBB {
     @Override
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
        if (dato <= nodo.getDato()) {  // Cambio de < a <=
            nodo.setIzq(insertarNoBalanceado(nodo.getIzq(), dato));
        } else {
            nodo.setDer(insertarNoBalanceado(nodo.getDer(), dato));
        }
        
        return nodo;
    }
    
    private Nodo encontrarMinimo(Nodo nodo) {
    if (nodo == null) {
        return null;
    }
    while (nodo.getIzq() != null) {
        nodo = nodo.getIzq();
    }
    return nodo;
}

    @Override
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
        
        return nodo;
    }

    public int contarOcurrencias(char letra) {
        int dato = LetraUtils.letraANumero(letra);
        return contarOcurrencias(raiz, dato);
    }

    private int contarOcurrencias(Nodo nodo, int dato) {
        if (nodo == null) {
            return 0;
        }
        
        int count = (nodo.getDato() == dato) ? 1 : 0;
        return count + contarOcurrencias(nodo.getIzq(), dato) 
                   + contarOcurrencias(nodo.getDer(), dato);
    }
}