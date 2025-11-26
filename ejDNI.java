import ES.ES;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;


public class ejDNI{
    public static void main(String[] args) {
        String entrada = "";
		do {
			entrada = ES.leeDeTeclado("Introduce el numero del DNI (8 digitos): ");
			if ((!entrada.matches("\\d{8}") || (!entrada.matches("\\d{8} [\s\-]? [A-Z]"))))
				System.out.println("Error: Debes introducir exactamente 8 digitos.");
		}while ((!entrada.matches("\\d{8}") || (!entrada.matches("\\d{8} [\s\-]? [A-Z]"))));
			
        int dni = Integer.parseInt(entrada);

        char[] letras = {
            'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'
        };

        char letra = letras[dni % 23];

        System.out.println("El DNI es: "+dni + letra);
    }
}