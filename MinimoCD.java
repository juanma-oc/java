import ES.ES;
import java.lang.Math;

public class MinimoCD {	

	public static void main(String[] args){		

	System.out.println("Vamos a calcular el MCD de dos numeros");
	int num1 = ES.leeN("Introduce un numero: ");
	int num2 = ES.leeN("Introduce el segundo numero: ");
	
	System.out.println("El MCD de "+ num1 + " y " + num2 + " es " + cal_minimoCD(num1,num2));
	System.out.println(calcularFactRec(num1));
	}
	
	public static int cal_minimoCD (int num1, int num2){
		int a = (num1>num2)?num1:num2; 
		int b = (num1>num2)?num2:num1;
		return ((a%b)==0)?b:cal_minimoCD(b,a%b);
	}
	
	public static int calcularFactRec (int numero){
		return (numero<2)?numero:numero*calcularFactRec(numero-1);
	}
}