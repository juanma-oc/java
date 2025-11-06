import ES.ES;
import java.lang.Math;
import java.util.Arrays;

public class pruebaClasesArray{

	public static void main(String[] args) {
        //Crea el array y luego lo rellena de numeros aleatorios del 1 al 100
		int numeros1 [] = new int [1000];
		Arrays.fill(numeros1, 100);
		for(int i = 0; i < 1000; i++){
			numeros1[i] = aleatorio(1,100);
		}
		//Lista todo el contenido del array
		System.out.println("Array desordenado: ");
		listarNumeros(numeros1);
        System.out.println();

        //Ordena los numeros dentro del array y luego lo lista
		Arrays.sort(numeros1);
		System.out.println("Array ordenado: ");
		listarNumeros(numeros1);
        System.out.println();
		

        //Crea un array con 10 posiciones y los lista
		int numeros2 [] = new int [10];
        listarNumeros(numeros2);
        System.out.println();

        //Copia todo el contenido del primer array y lo introduce en el numero 2. Luego lo lista
        numeros2 = Arrays.copyOf(numeros1,numeros1.length);
		listarNumeros(numeros2);
        System.out.println();		

        //Pregunta un numero para buscarlo en el array 
		int num = ES.leeN("Introduce un número: ", 1, 100);
		int cont = 0;
        //Recorre el array y comprueba las veces repetidas y la primera vez que aparece
		for (int i = 0; i < numeros2.length; i++){
			if (numeros2[i] == num ){
				if (cont == 1){
				    System.out.println("El número " + num + " aparece por primera vez en la posicion " + i);
			    }
                cont++;
			}
		}
		System.out.println("El numero introducido aparece " + cont + " veces");
        System.out.println();

        //Creo una variable que muestra la primera posicion del numero que se busca
        int busc = Arrays.binarySearch(numeros2,num);
        //Probando si sale en la misma linea, me he fijado que el binarySearch no muestra la primera posicion en la que sale, casi nunca coincide con el de arriba
        //System.out.println("El número " + num + " aparece por primera vez en la posicion " + busc);
        if (busc > -1)
            System.out.println("El numero introduce aparece "+encontrarNum(numeros2,num,busc,1)+" veces.");
	}

    
    //Funcion para revisar las veces que se repite el numero dentro del array, hecha de forma recursiva hasta que no encuentra mas numeros iguales.
    // Recibe el array, el numero que se quiere buscar, la primera posicion en la que aparecio y las veces que se ha encontrado
    public static int encontrarNum (int[] listaNumero, int numBuscar, int inicio, int vecesEncontrado){
        if (listaNumero[inicio] != numBuscar)
            return vecesEncontrado;
        else {
            vecesEncontrado++;
            inicio++;
            return encontrarNum(listaNumero,numBuscar,inicio,vecesEncontrado);
        }
    }
    
	public static int aleatorio(int min, int max){
		int numAle =  (int) Math.floor(Math.random()*(max-min+1)+min);
		return numAle;
	}

    public static void listarNumeros (int[] listarNumeros){
	    for (int i = 0; i < listarNumeros.length; i++){
			System.out.print(listarNumeros[i] + " ");
			if (i % 50 == 0 && i>0){
				System.out.println();
			}
		}
        System.out.println();
    }
}