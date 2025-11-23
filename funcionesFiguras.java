import java.util.Arrays;
import ES.ES;

public class funcionesFiguras {
	public static void main(String[] args){
        int figura;
        String caracter;
        int base;
        int altura;

        System.out.println("Figuras:");
        System.out.println("1. Cuadrado");
        System.out.println("2. Rectangulo");
        System.out.println("3. Triangulo");
        System.out.println("4. Piramide");
        System.out.println("5. Rombo");

        System.out.println("");
        figura = ES.leeN("¿Que figura quieres dibujar? ");
        
        switch (figura) {
            case 1:
                altura = ES.leeN("Introduce la altura del cuadrado: ");
                caracter = ES.leeDeTeclado("Introduce el caracter con el que dibujar la figura");
                cuadrado(altura,caracter);
                break;

            case 2:
                altura = ES.leeN("Introduce la altura del rectangulo: ");
                base = ES.leeN("Introduce la base del rectangulo: ");
                caracter = ES.leeDeTeclado("Introduce el caracter con el que dibujar la figura");
                rectangulo(altura, base, caracter);
                break;

            case 3:
                altura = ES.leeN("Introduce la altura del triangulo: ");
                caracter = ES.leeDeTeclado("Introduce el caracter con el que dibujar la figura");
                triangulo(altura, caracter);
                break;

            case 4:
                altura = ES.leeN("Introduce la altura de la piramide: ");
                caracter = ES.leeDeTeclado("Introduce el caracter con el que dibujar la figura");
                piramide(altura, caracter);
                break;

            case 5:
                altura = ES.leeN("Introduce la altura del rombo: ");
                caracter = ES.leeDeTeclado("Introduce el caracter con el que dibujar la figura");
                rombo(altura, caracter);
                break;

            default:
                System.out.println("La opcion que has eligido no es valida..");
                break;
        }
    }



    public static void cuadrado(int altura, String caracter){
        String[][] figura = new  String [altura] [altura];
        
        for(int i=0;i<figura.length;i++){
            for(int j=0; j<figura[i].length;j++){
                figura[i][j] = caracter;
                System.out.print(figura[i][j]);
            }
            System.out.println();
        }
    }

    public static void rectangulo(int altura, int base, String caracter){
        String[][] figura = new  String [altura] [base];
        
        for(int i=0;i<figura.length;i++){
            for(int j=0; j<figura[i].length;j++){
                figura[i][j] = caracter;
                System.out.print(figura[i][j]);
            }
            System.out.println();
        }
    }

    public static void triangulo(int altura, String caracter){
        String[][] figura = new  String [altura] [altura];
        
        for(int i=0;i<figura.length;i++){
            for(int j=0; j<figura[i].length;j++){
                if (j <= i)
                    figura[i][j] = caracter;
                else 
                    figura [i][j]= "";
                
                System.out.print(figura[i][j]);
            }
            System.out.println();
        }
    }

    public static void piramide(int altura, String caracter){
        String[][] figura = new  String [altura] [2*altura-1];
        
        for(int i=0;i<figura.length;i++){
            for(int j=0; j<figura[i].length;j++){
                if (j >= (altura - i -1) && j<= (altura+i-1))
                    figura[i][j] = caracter;
                else 
                    figura [i][j]= " ";
                
                System.out.print(figura[i][j]);
            }
            System.out.println();
        }
    }

    public static void rombo(int altura, String caracter){
        String[][] figura = new  String [2*altura-1] [2*altura-1];
        
        for(int i=0;i<figura.length;i++){
            for(int j=0; j<figura[i].length;j++){
                if (i < altura) { // parte superior
                    if (j >= (altura - i - 1) && j <= (altura + i - 1))
                        figura[i][j] = "*";
                    else
                        figura[i][j] = " " ;
                } else { // parte inferior
                    int inf = i - altura + 1;
                    if (j >= inf && j <= (2*altura - 2 - inf))
                        figura[i][j] = "*";
                    else
                        figura[i][j] = " ";
                }
                System.out.print(figura[i][j]);
            }
            System.out.println();
        }
    }
}