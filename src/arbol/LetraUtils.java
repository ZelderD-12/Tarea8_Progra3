package arbol;

public class LetraUtils {
    public static int letraANumero(char letra) {
        if (letra < 'a' || letra > 'z') {
            throw new IllegalArgumentException("Solo se permiten letras minúsculas de la 'a' a la 'z'");
        }
        return letra - 'a' + 1;
    }

    public static char numeroALetra(int numero) {
        if (numero < 1 || numero > 26) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 26");
        }
        return (char) ('a' + numero - 1);
    }

    public static boolean esLetraValida(String input) {
        return input != null && input.length() == 1 && 
               input.charAt(0) >= 'a' && input.charAt(0) <= 'z';
    }
}