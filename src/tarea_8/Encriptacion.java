
package tarea_8;
import java.util.ArrayList;
import java.util.Random;

public class Encriptacion {
    
    public Encriptacion(){}
    
    public String IniciarEncriptacion(String mensajefacil) throws InterruptedException{
        Random rand = new Random();

        String[] letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z","á","é","í","ó","ú","ü"};

        String mensajesinespacios = mensajefacil.replaceAll("\\s+", "");
        String mensajenciptado = mensajesinespacios; // Iniciamos con el mensaje limpio

        int desplazamiento = 0; // Cuántos caracteres hemos insertado en total

        for (int i = 0; i < mensajesinespacios.length(); i++) {
            int cantidadnuevasletras = rand.nextInt(3) + 1;
            String letrasNuevas = "";

            for (int j = 0; j < cantidadnuevasletras; j++) {
                int indiceAleatorio = rand.nextInt(letras.length);
                letrasNuevas += letras[indiceAleatorio];
            }

            letrasNuevas += ".";
            
            int posicionInsercion = i + desplazamiento;

            mensajenciptado = mensajenciptado.substring(0, posicionInsercion) + letrasNuevas + mensajenciptado.substring(posicionInsercion);

            desplazamiento += letrasNuevas.length();

            Thread.sleep(500);
        }
        
        
        return mensajenciptado;
    }
}
