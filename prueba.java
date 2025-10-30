import ES.ES;
import java.lang.Math;

public class prueba{

	public static void mult10 (int num1){
		int tabla;
		for (i=1; i <= 10; i++){
			tabla = num1 * i;	
			System.out.print("El numero "+num+" multiplicado por "+i+" es "+tabla );  //imprime en la misma linea
		}
	}

	public static double temperatura (int temp, char tipo ){
		if (tipo == 'C') {
			return (temp * 9 / 5) + 32;
		} 
		else if (tipo =='F'){
			return (temp-32) * 5 / 9;
		} 
		else 
			return -1;
	}
		
		


	public static void main (String [] args){
		int min = ES.leeN("Introduce un numero min: ",0,19);
		int max = ES.leeN("Introduce un numero maximo: ",min,20);
		
		for (int i = 1; i < 11; i++){
			int alea = aleatorio(min,max);
			System.out.println("El nuymero " + i + " generado ha sido "+ alea);
		}	
		
		int diaSemana = ES.leeN("Introduce dia de la semana: ",1,7);
		
		String dia;
		boolean seTrabaja = true;
		
		switch (diaSemana){
			case 1:
				dia="Lunes";
				seTrabaja = true;
				break;
			case 2:
				dia="Martes";
				seTrabaja = true;
				break;
			case 3:
				dia="Miercoles";
				seTrabaja = true;
				break;				
			case 4:
				dia="Jueves";
				seTrabaja = true;
				break;				
			case 5:
				dia="Viernes";
				seTrabaja = true;	
				break;
			case 6:
				dia="Sabado";
				seTrabaja = false;				
				break;
			case 7:
				dia="Domingo";
				seTrabaja = false;				
				break;
			default:
				dia = "?";
		}
		
		if (seTrabaja)
			System.out.println("El dia de la semana es " + dia + " y este dia se trabaja cojones");
		else
			System.out.println("El dia de la semana es " + dia + " y este dia se parte cojones");
		
		int i = 1; 
		while (i <= 100){
			System.out.println(i);
			i++;
		}
		
		int i = 1;
		do {
			System.out.println(i);
			i++;
		} while (i <= 100);
		
	}

		int grados = ES.leeN("Introduce la temperatura");
		char tipo = ES.leeCaracter("Introduce el tipo de grado (Celsius[C] o Fahrenheit[F])");
		double temp = temperatura(grados,tipo);

		if (tipo == "C"){
			System.out.println(grados + "ºC equivalen a " + temp +"ºF" );
		} 
		else if (tipo == "F"){
			System.out.println(grados + "ºF equivalen a " + temp+ "ºC" );
		}

//----------------------------------------------------------------------------
	public static int aleatorio(int min, int max){
		int numAle =  (int) Math.floor(Math.random()*(max-min+1)+min);
		return numAle;
	}
}
