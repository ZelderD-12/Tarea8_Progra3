package arbol;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;


public class ArbolExpresionGrafico extends JPanel {
    private ArbolBB miArbol;
    private HashMap<Nodo, Rectangle> posicionNodos;
    private HashMap<Nodo, Dimension> subtreeSizes;
    private boolean dirty = true;
    private int parent2child = 20, child2child = 30;
    private Dimension empty = new Dimension(0, 0);
    private FontMetrics fm = null;
    private JScrollPane scrollPane;

    public ArbolExpresionGrafico(ArbolBB miArbol, JScrollPane scrollPane, JPanel panel) {
        this.miArbol = miArbol;
        this.scrollPane = scrollPane;
        this.setBackground(Color.WHITE);
        posicionNodos = new HashMap<>();
        subtreeSizes = new HashMap<>();
        dirty = true;
        
        // Configurar el layout y propiedades del panel
        panel.setLayout(new BorderLayout());
        panel.add(this, BorderLayout.CENTER);
        
        // Configurar el scroll pane
        scrollPane.setViewportView(panel);
        scrollPane.setPreferredSize(new Dimension(800, 600));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        fm = g.getFontMetrics();

        if (dirty) {
            calcularPosiciones();
            dirty = false;
        }

        if (miArbol.getRaiz() != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(getWidth() / 2, parent2child);
            dibujarArbol(g2d, miArbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, fm.getLeading() + fm.getAscent());
        }
    }

    private void calcularPosiciones() {
        posicionNodos.clear();
        subtreeSizes.clear();
        Nodo root = miArbol.getRaiz();
        if (root != null) {
            calcularTamañoSubarbol(root);
            calcularPosicion(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
        }
    }

    private Dimension calcularTamañoSubarbol(Nodo n) {
        if (n == null) return new Dimension(0, 0);
       
        if (fm == null) {
            return new Dimension(0, 0);
        }

        Dimension ld = calcularTamañoSubarbol(n.getIzq());
        Dimension rd = calcularTamañoSubarbol(n.getDer());

        int h = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
        int w = ld.width + child2child + rd.width;

        Dimension d = new Dimension(w, h);
        subtreeSizes.put(n, d);

        return d;
    }

    private void calcularPosicion(Nodo n, int left, int right, int top) {
        if (n == null) return;

        Dimension ld = subtreeSizes.getOrDefault(n.getIzq(), empty);
        Dimension rd = subtreeSizes.getOrDefault(n.getDer(), empty);

        int center = 0;

        if (right != Integer.MAX_VALUE)
            center = right - rd.width - child2child / 2;
        else if (left != Integer.MAX_VALUE)
            center = left + ld.width + child2child / 2;

        int width = fm.stringWidth(n.getDato() + "");

        posicionNodos.put(n, new Rectangle(center - width / 2 - 3, top, width + 6, fm.getHeight()));

        calcularPosicion(n.getIzq(), Integer.MAX_VALUE, center - child2child / 2, top + fm.getHeight() + parent2child);
        calcularPosicion(n.getDer(), center + child2child / 2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child);
    }

    private void dibujarArbol(Graphics2D g, Nodo n, int puntox, int puntoy, int yoffs) {
    if (n == null) return;

    Rectangle r = posicionNodos.get(n);
    if (r == null) return;

    // Dibujar el nodo con posible indicador de duplicados
    g.draw(r);
    String texto = String.valueOf(n.getLetra());
    
    // Si hay duplicados, mostrar un pequeño número (opcional)
    int duplicados = contarDuplicados(n);
    if (duplicados > 0) {
        texto += " (" + (duplicados + 1) + ")";
    }
    
    g.drawString(texto, r.x + 3, r.y + yoffs);

    if (puntox != Integer.MAX_VALUE)
        g.drawLine(puntox, puntoy, (int)(r.x + r.width/2), r.y);

    dibujarArbol(g, n.getIzq(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
    dibujarArbol(g, n.getDer(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
}

// Método auxiliar para contar duplicados en el subárbol izquierdo
private int contarDuplicados(Nodo nodo) {
    if (nodo == null || nodo.getIzq() == null) return 0;
    return contarDuplicados(nodo.getIzq(), nodo.getDato());
}

private int contarDuplicados(Nodo nodo, int valor) {
    if (nodo == null) return 0;
    if (nodo.getDato() == valor) {
        return 1 + contarDuplicados(nodo.getIzq(), valor);
    }
    return 0;
}

    @Override
    public Dimension getPreferredSize() {
        if (miArbol.getRaiz() == null) {
            return new Dimension(0, 0);
        }

        Rectangle bounds = calcularLimitesArbol(miArbol.getRaiz());
        int width = bounds.width + 50;
        int height = bounds.height + 50;

        return new Dimension(width, height);
    }

    private Rectangle calcularLimitesArbol(Nodo nodo) {
        if (nodo == null) {
            return new Rectangle(0, 0, 0, 0);
        }

        Rectangle leftBounds = calcularLimitesArbol(nodo.getIzq());
        Rectangle rightBounds = calcularLimitesArbol(nodo.getDer());

        int width = leftBounds.width + rightBounds.width + 100;
        int height = Math.max(leftBounds.height, rightBounds.height) + 50;

        return new Rectangle(0, 0, width, height);
    }

    public void desplazarANodo(Nodo nodo) {
        if (nodo != null && posicionNodos.containsKey(nodo)) {
            Rectangle rect = posicionNodos.get(nodo);
            scrollPane.getViewport().scrollRectToVisible(rect);
        }
    }
}