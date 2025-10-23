import ES.ES;
import Java.lang.Math;

public class Triangulo{
	
	public static void main (String [] args){
		int base = ES.leeN("Introduce la base del triangulo");
		int altura = ES.leeN("Introduce la altura del triangulo");
		
		int area = (base*altura)/2;
		System.out.println("El area del triangulo es: " + area);		
	}
}