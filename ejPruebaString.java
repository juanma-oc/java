import ES.ES;
import java.lang.Math;
import java.util.Arrays;

public class ejPruebaString{
	public static void main(String[] args) {
		int numPal = ES.leeN("Introduce cuantas palabras introducir: ",2,4);
		String palabras[] = new String[numPal];
		
		for (int i=0;i<numPal;i++)
			palabras[i]= ES.leeDeTeclado("Escribe la "+(i+1)+" palabra.");	
		
		System.out.println("Palabras en Mayuscula");
		for(int i=0;i<palabras.length;i++)
			System.out.println(palabras[i].toUpperCase());
		
		System.out.println("Estos son los 3 primeros caracteres de cada palabra");
		for(int i=0;i<palabras.length;i++)
			System.out.println(palabras[i].substring(0,3));
		
		int cont=0;
		String palabra;
		for(int i=0;i<palabras.length;i++){
			palabra = palabras[i];
			for (int j=0;j<palabras[i].length();j++)
				if(palabra.charAt(j)=='a')
					cont++;
			System.out.println("La palabra "+palabras[i]+" tiene "+cont+" a's");
		cont = 0;
		}
		
		int pos_a;
		for(int i=0;i<palabras.length;i++){
			pos_a=palabras[i].lastIndexOf("a");
			if(pos_a<0)
				System.out.println("La palabra "+palabras[i]+" no contiene la letra a.");
			else 
				System.out.println("La ultima aparacicion de a en la palabra "+palabras[i]+" es en la posicion "+(palabras[i].lastIndexOf("a")+1));
		}
		
		System.out.println("La palabras palabras al reves son: ");
		String pal_reverse = "";
		for(int i=0;i<palabras.length;i++){
			for(int j=palabras[i].length()-1;j>=0;j--){
				pal_reverse += palabras[i].charAt(j);
			}
			System.out.println(pal_reverse);
			pal_reverse="";
		}
	
		for(int i=0;i<palabras.length;i++){
			palabra=palabras[i];
			System.out.println("La palabra "+palabras[i]+" tiene "+encontrarARecursiva(palabra)+" a's");
		}
	}
	
	public static int encontrarARecursiva (String palabra){
		if ((palabra.length()==0) || (palabra.indexOf("a")==-1))
			return 0;
		else{
			palabra = palabra.substring(palabra.indexOf("a"));
			return 1 + encontrarARecursiva(palabra);			
		}
	}
}
