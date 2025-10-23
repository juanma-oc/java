import ES.ES;
import java.lang.Math;

public class ejclase1{
	
	public static void main (String [] args){
		
		int i = 1;
		int num1  = 1;
		for (i = 0; (i < 5) && (num1 != 0); i ++) {
			num1 = ES.leeN("Introduce un numero: ");	
		}
		
		int num2 = 0; 
		int resto = 1; 
		do {
			num2 = ES.leeN("Introduce un numeroWA: ",750);
			resto = num2 % 7;
		}while (resto!=0);
	}
}