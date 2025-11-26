import java.util.Arrays;
import ES.ES;

public class DNIClase {
	public static void main(String[] args){
        String dni;
        String comprob;

        //Comprueba si se han introducido parametros
        if (args.length>0){
            comprob = args[0];

            //Comprueba si algunas de las dos opciones si da o no
            if ((comprob.matches("[0-9]{8}[\s\-]?[A-Z]?")) )
                dni = args[0];
            else{
                System.out.println("El argumento introducido no es correcto");
                dni = pedirDNI();
            }

        //Si no hay argumento entra aqui        
        }else{
            System.out.println("No se ha pasado el DNI como parametro.");
            dni = pedirDNI();
        }

        char[] letras = {
            'T','R','W','A','G','M','Y','F','P','D','X','B',
            'N','J','Z','S','Q','V','H','L','C','K','E'
        };

        int numDNI = Integer.parseInt(dni.substring(0, 8));
        char letra = letras[(numDNI%23)];

        System.out.println("La letra del DNI introducido es: " + dni + letra);

    }

    public static String pedirDNI(){
        String dni;
        do{
            dni = ES.leeDeTeclado("Introduce los digitos del DNI: ");
            if ((!dni.matches("[0-9]{8}[\s\-]?[A-Z]?")))
                System.out.println("Error! Debes introducir 8 digitos");
        }while ((!dni.matches("[0-9]{8}[\s\-]?[A-Z]?")));
        return dni;
    }
}