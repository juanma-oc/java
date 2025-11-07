import ES.ES;
import java.lang.Math;

public class Arrays {	

	public static void main(String[] args){		
	
		int cantAlumnos = ES.leeN("Introduce la cantidad de alumnos en la clase: ",5,30);
		int notas[]= new int[cantAlumnos];
		
		int nota0 = ES.leeN("Dime la nota del alumno 1: ");
		notas[0]=nota0;
		int nota1 = ES.leeN("Dime la nota del alumno 2: ");
		notas[1]=nota1;
		for(int i=2;i<cantAlumnos;i++){
			notas[i]= aleatorio(0,10);
		}
		
		boolean salida = false;
		do {
			switch (menu()){
				case 1: 
					System.out.println("La nota mas baja ha sido un "+ calcMin(notas,cantAlumnos));
					break;
				case 2:
					System.out.println("La nota mas alta ha sido un "+ calcMax(notas,cantAlumnos));
					break;
				case 3:
					System.out.println("La nota media ha sido "+ calcNotaM(notas,cantAlumnos));
					break;
				case 4:
					System.out.println("El numero de aprobados ha sido "+ calcAprob(notas,cantAlumnos));
					break;
				case 5:
					System.out.println("El porcentaje de aprobados es del "+ (calcAprob(notas,cantAlumnos) * 100 / cantAlumnos)+ "%");
					break;
				case 0:
					salida = true;
					break;
			}		
		}while (!salida);
	
		

	}

	public static int menu (){
		System.out.println("1. Nota Minima");
		System.out.println("2. Nota Maxima");
		System.out.println("3. Nota Media");
		System.out.println("4. Numero de Aprobados");
		System.out.println("5. Porcentaje de Aprobados");
		System.out.println("0. Salir");
		return ES.leeN("Introduce el numero deseado ",0,5);
	}
	
	public static int calcMin (int[] notas, int cantAlumnos ){
		int notaMin = 10;
		for (int i=0;i<cantAlumnos;i++) {
			if (notas[i]<notaMin){
				notaMin = notas[i];	
			}
		}
		return notaMin;
	}
	
	public static int calcMax (int[] notas, int cantAlumnos){
		int notaMax = 0;
		for (int i=0;i<cantAlumnos;i++) {
			if (notas[i]>notaMax){
				notaMax = notas[i];		
			}
		}
		return notaMax;
	}

	public static int calcNotaM (int[] notas, int cantAlumnos){
		int notaMedia=0;
		for (int i=0;i<cantAlumnos;i++) {
			notaMedia = notaMedia + notas[i];			
		}
		return notaMedia / cantAlumnos;
	}

	public static int calcAprob (int[] notas, int cantAlumnos){
		int numAprobados = 0;
		for (int i=0;i< cantAlumnos;i++) {
			if (notas[i]>=5)
				numAprobados += 1;
		}
		return numAprobados;
	}
		
	public static int aleatorio(int min, int max){
		int numAle =  (int) Math.floor(Math.random()*(max-min+1)+min);
		return numAle;
	}
}