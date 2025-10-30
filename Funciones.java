import ES.ES;
import java.lang.Math;
public class Funciones {
	
	public static void main(String[] args){
	
	/*int base=ES.leeN("Introduce un numero: ");
	System.out.println("Los 10 primeros multiplos de "+base+" son: ");
	multiplos(base);*/
	
	double temperatura = ES.leeN("Introduzca grados a convertir: ");
	char tipo = ES.leecaracter("¿De qué tipo son? (C Celsius, F Fahrenheit): ");
	
	System.out.println(temperatura+" grados "+tipo+" equivale a "+redondear((float) conversorGrados(temperatura, tipo),2));	

	
	int numFact = ES.leeN("Introduce un numero para calcular su factorial: ");
	System.out.println(numFact+"! es :"+calcular_factorial(numFact) );
	
	int numFact2 = ES.leeN("Introduce un numero para calcular su factorial: ");
	System.out.println(calcular_factorialRecursiva(numFact2));
	
	int numRec = ES.leeN("Introduce un numero: ");
	int numMult = ES.leeN("Por cuanto lo quieres multiplicar");
	System.out.println(cal_multRecursiva(numRec,numMult));
	
	}
	
	public static int cal_multRecursiva(int num, int mult){
		if (mult == 0 )
			return 0;
		else if (mult == 1)
			return num; 
		else 
			return num + cal_multRecursiva(num,mult-1);
	}
	
	public static int calcular_factorialRecursiva (int numero){
		if (numero<2) 
			return numero;
		else
			return numero * calcular_factorialRecursiva(numero-1);	
	}
	
	public static int calcular_factorial(int numFact){
		int factorial = 1;
		for (int i=0;i<numFact;i++){
			factorial *= (numFact-i);
		}
		return factorial;
	}
	
	public static float redondear(float numero, int dec){
	//	System.out.println("recibo "+numero);
	//	System.out.println("devuelvo "+(float) (Math.round((numero)*(Math.pow(10,dec)))/(Math.pow(10,dec))));
		return (float) (Math.round((numero)*(Math.pow(10,dec)))/(Math.pow(10,dec)));
	}
	
	public static float doble(float numero){
		return (numero*2);
	}
	
	public static boolean es_doble(int num1, int num2){
		
		return (((num1*2)== num2) || ((num2*2)== num1));
		
	}
	
	public static int mayorDe3(int num,int num2,int num3){	
		return (int) mayorDe3((double) num,(double) num2,(double) num3);
	}
	
	public static double mayorDe3(double num,double num2,double num3){	
		if ((num>num2) && (num>num3)){
			return num;
		}else{
			if (num2>num3){
				return num2;
			}else{
				return num3;
			}
		}
	}
	
	public static int potencia(int base,int expo) {

		int pot=1;
		for (int i=0;i<expo;i++)
			pot=pot*base;			
		return pot;
	}
	
	public static void multiplos(int numero_mul){
		
		for(int i = 1; i <= 10; i++){
			int resultado_mul = numero_mul * i;
			System.out.print(resultado_mul+" ");
		}
	}
	
	public static double conversorGrados (double grados, char tipo){
		if (tipo == 'F'){
			return (grados - 32)/1.8;
		} 
		else if (tipo == 'C'){
			return (grados * 1.8f) + 32;
		}
		return -1;
	}
}