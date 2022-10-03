import java.util.Random;
import java.util.Scanner;

public class El_Ahorcado {
    public static void main(String[] args) {
        juego();
    }

    public static String generarPalabra() {
        Random aleatorio = new Random();
        String[] palabras = {"bigtimerush", "candela", "ampere", "grefg", "proyecto", "intranet", "nocturna", "pizarra", "meganoticias"};
        int palabra = aleatorio.nextInt(palabras.length);

        String palabraEscogida = palabras[palabra];

        return palabraEscogida;
    }

    public static char[] generarpalabraGuionesBajos(String palabra) {
        int numeroDeLetrasDePalabra = palabra.length();
        char[] guionesBajos = new char[numeroDeLetrasDePalabra];
        for (int i = 0; i < guionesBajos.length; i++) {
            guionesBajos[i] = '_';
        }
        return guionesBajos;
    }

    public static void juego(){
        Scanner leer = new Scanner(System.in);
        String palabra = generarPalabra();
        char[] palabraGuionesBajos = generarpalabraGuionesBajos(palabra);
        boolean juegoTerminado = false;
        int intentos = 10;
        do{
            System.out.println("Te quedan "+intentos+" intentos.");
            System.out.println(palabraGuionesBajos);
            System.out.println("A continuación ingrese una letra: ");
            char letra = leer.next().charAt(0);
            boolean letraAcertada = false;
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    palabraGuionesBajos[i] = letra;
                    letraAcertada = true;
                }
            }
            if (!letraAcertada) {
                System.out.println("No has hacertado ninguna letra.");
                intentos = intentos - 1;
                if(intentos == 0){
                    System.out.println("Has perdido, por agotar intentos.");
                    juegoTerminado = true;
                }
            } else {
                boolean juegoGanado = !hayGuiones(palabraGuionesBajos);
                if(juegoGanado){
                    System.out.println("Has ganado el juego.");
                    juegoTerminado = true;
                }
            }
        }while(!juegoTerminado);

        leer.close();

    }

    static boolean hayGuiones(char[] array) {
        for (char l:array) {
            if (l == '_') return true;
        }
        return false;
    }
}