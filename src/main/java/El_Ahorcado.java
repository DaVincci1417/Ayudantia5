import java.util.Random;

public class El_Ahorcado {
    public static void main (String [] args){
        String palabra = generarPalabra();

    }

    public static String generarPalabra(){
        Random aleatorio = new Random();
        String [] palabras = {"bigtimerush","candela","ampere","grefg","proyecto","intranet","nocturna","pizarra","meganoticias"};
        int palabra = aleatorio.nextInt(palabras.length);

        String palabraEscogida = palabras[palabra];

        return palabraEscogida;
    }
}