import ES.ES;
import java.lang.Math;
import java.util.Arrays;

public class ejPrimitiva {
	public static void main(String[] args){
        int primitiva [][];
		final char SIGNOS [] = {'1','X','2'} ;
		int napuestas;
		int primitivaGanadora[];
		String cabecera="Primitiva.\t\t";
		int numAciertos;
		
		if (args.length==1){
			napuestas = Integer.parseInt(args[0]);
			if (!(napuestas>0))
				System.out.println("El numero de apuestas introducido no es correcto");
				
		}else{
			System.out.println("El numero de parametros introducido incorrecto");
			napuestas=1;
		}
		
		System.out.println("Generando "+ napuestas+ " apuestas...");
		primitiva = new int[napuestas][8];
		primitivaGanadora= new int [1];
		
		for (int i=0;i<6;i++){
			cabecera += "Num "+(i+1)+".\t";
		}
		cabecera+= "N.Compl\t N.Reint";
		
		System.out.println(cabecera);
		System.out.println();
		
		int num;
		
		for (int i=0;i<primitiva.length;i++){
			System.out.print("Apuesta n"+(i+1)+". \t\t");			
			for(int j=0;j<primitiva[i].length;j++){
				if (j<7)
					do{
						num=aleatorio(1,49);
						if (Arrays.binarySearch(primitiva[i],num)==-1)
							primitiva[i][j] = num;						
					}while (Arrays.binarySearch(primitiva[i],num)>=0);
				else
					primitiva[i][j]=(aleatorio(0,9));
			}
			Arrays.sort(primitiva[i],0,6);
			
			for(int j=0;j<primitiva[i].length;j++){
				System.out.print(primitiva[i][j]+"\t");
			}
			System.out.println();
		}		
		System.out.println();
	}	
	public static int aleatorio(int min, int max){
		int numAle =  (int) Math.floor(Math.random()*(max-min+1)+min);
		return numAle;
	}
}