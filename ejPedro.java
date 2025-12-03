import ES.ES;
import java.lang.Math;
import java.util.Arrays;

public class ejPedro {
	public static void main(String[] args){
		int num;
		int jk;
		
		System.out.println("APUESTAS DEL ESTADO");
		num=ES.leeN("Numero de apuestas que quieres: ");
		
		for(int i=1;i<=num;i++){
			System.out.print("Apuesta n."+(i)+ pintaArrays(primitiva()));
			System.out.println();
			
		}		
		System.out.println("Reintegro-->"+ combinacion(0,9,1)[0]);
		
		jk=ES.leeN("Quieres Joker? (0-NO,1-SI)",0,1);
		if (jk==1)
			System.out.println("Joker-->"+ combinacion(0,99999,1)[0]);
	
	}	
	public static String pintaArrays(int array[]){
		String salida ="";
		for (int i=0;i<array.length;i++){
			salida+=(array[i]+",");
		}
		return salida.substring(0,array.length-1);
	}
		
	
	public static int [] primitiva (){
		return combinacion(0,49,6);
	}

	public static int [] combinacion(int min, int max, int ctd){
		int numeros []= new int [ctd];
		int num;
		
		for (int i=0; i<numeros.length;i++){
			do {
				num = aleatorio(min,max);			
			}while (buscar(numeros,num));
			numeros[i]=num;
		}	
		
		Arrays.sort(numeros);
		return numeros;	
	}
	
	public static boolean buscar(int numeros[], int num){
		for (int i=0;i<numeros.length;i++){
			if(numeros[i]==num)
				return true;
		}
		return false;	
	}
	
	public static void menu(){
		System.out.println("CASA DE APUESTAS: ");
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("5. ");
		System.out.println();
	}
	
	public static int aleatorio(int min, int max){
		int numAle =  (int) Math.floor(Math.random()*(max-min+1)+min);
		return numAle;
	}
}