import ES.ES;
import java.lang.Math;

public class Arrays2Dims {	

	public static void main(String[] args){
		int numAlum = ES.leeN("Introduce número de alumnos: ",1,30);
		int numNotas = ES.leeN("Introduce el número de notas: ",1,100);
		
		//Añado 1 fila y 1 columna para guardar las notas 
		//medias por alumno y por tarea
		String  notas[][] = new String[numAlum+1][numNotas+2];
		
		for (int i=0;i<numAlum;i++){
			notas[i][0] = ES.leeDeTeclado("Introduce el nombre del alumno: "+(i+1));
			
		}
			
		int nota = 0 ; 
		float media = 0;
		for (int i=0;i<numAlum;i++){
			nota = ES.leeN("Introduce la nota de "+notas[i][0]+" ",0,10);
			media += nota;
			notas[i][1]= String.valueOf(nota);
		}

		int nota2 =  0; 
		float media2 = 0;
		for (int i=0;i<numAlum;i++){
			for (int j=2;j<numNotas+1;j++){
			nota2 = aleatorio(0,10);
			media2 += nota2;
			notas[i][j]= String.valueOf(nota2);	
			}

		}
	
		completarTabla(notas);
		listarNotas(notas);
	}		
			
/*int notas[][] = new int[numAlum][3];
		float nmev[] = new float[3];
			
		for(int i=0;i<numAlum;i++)
			for(int j=0;j<3;j++)
				notas[i][j]=aleatorio(0,10);			
		System.out.println("\t1EV\t2EV\t3EV");
		System.out.println("\t---\t---\t---");
			
		for(int i=0;i<numAlum;i++){
			System.out.print(i);
			for(int j=0;j<3;j++){
				System.out.print("\t "+notas[i][j]);
				nmev[j]+=notas[i][j];
			}
			System.out.println();
		}
			
		System.out.println("\t---\t---\t---");
		for(int j=0;j<3;j++){
			nmev[j]=nmev[j]/numAlum;
			System.out.print("\t "+redondear(nmev[j],2));
		}
		System.out.println();*/
		
	public static void completarTabla(String[][] misNotas){
		float suma; 
		int numNotas;
		for(int i=0;i<misNotas.length;i++){
			suma = 0;
			numNotas= misNotas[i].length;
			for(int j=1;j<numNotas-1;j++){
				suma += Float.parseFloat(misNotas[i][j]);
			}
			misNotas[i][numNotas-1]= String.valueOf(redondear(suma/(numNotas-2),2)); 
		}
		misNotas[misNotas.length-1][0]= "\tMedia T.";
	}	
		
	public static void listarNotas(String[][] misNotas){
		//imprimo cabecera
		System.out.print("\tNombre");
		for(int i=1;i<=misNotas[0].length-2;i++)
			System.out.print("\tTarea "+i);
		System.out.println("\tMedia alumno");
		
		//imprimo notas de los alumnos
		for(int i=0;i<misNotas.length;i++){
			for(int j=0;j<misNotas[i].length;j++){
				System.out.print("\t"+misNotas[i][j]);
			}
			System.out.println();
		}
	
	}
		
	public static int aleatorio(int min, int max) {
		return (int) Math.floor(Math.random()*(max-min+1)+min);
	}
		
	public static float redondear(float numero, int dec){	
		return (float) (Math.round((numero)*(Math.pow(10,dec)))/(Math.pow(10,dec)));
	}
	
}