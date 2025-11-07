import ES.ES;
import java.lang.Math;
import java.util.Arrays;


public class pruebaClaseArray {	

	public static void main(String[] args){
		int numEnteros[] = new int [1000];
		Arrays.fill(numEnteros,100);
		
		for (int i=0;i<numEnteros.length;i++){
			numEnteros[i] = aleatorio(1,100);
		}
		System.out.println("Array1 sin ordenar");	
		imprArrays(numEnteros);
		System.out.println();		
	
		Arrays.sort(numEnteros);
		System.out.println("Array1 ordenado");
		imprArrays(numEnteros);
		System.out.println();	

		int numEnteros2[] = new int [10];
		System.out.println("Array2 sin rellenar");
		imprArrays(numEnteros2);
		System.out.println();	
		
		numEnteros2=Arrays.copyOf(numEnteros,numEnteros.length);
		System.out.println("Array2 copiado del Array1");	
		imprArrays(numEnteros2);
		System.out.println();	
		
		int n = ES.leeN("Introduce un numero para buscar (1-100): ",1,100);
		int cont = 0;
		for (int i = 0; i < numEnteros.length;i++){
			if (numEnteros[i]==n && cont == 0){
				System.out.println("La primera posicion en la que sale el numero "+n+" es "+i);	
				cont++;
			}else if (numEnteros[i]==n)
				cont++;
		}
		System.out.println("El numero "+n+" aparece "+ cont+" veces");
		
		int h = Arrays.binarySearch(numEnteros,n)
		for (int i = h; i==n;i++)                       
		
		
	}
	
	public static void imprArrays(int [] numeros){
		for (int i=0; i<numeros.length;i++){
			System.out.print(numeros[i] + ", ");
			if (i%50==0 && i>0)
			System.out.println("");	
		}
		System.out.println();		
	}
	
	public static int aleatorio(int min, int max) {
		return (int) Math.floor(Math.random()*(max-min+1)+min);
	}
		
	public static float redondear(float numero, int dec){	
		return (float) (Math.round((numero)*(Math.pow(10,dec)))/(Math.pow(10,dec)));
	}
	
}