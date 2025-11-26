import ES.ES;
import java.lang.Math;
import java.util.Arrays;

public class quiniela {
	public static void main(String[] args){
        char quiniela [][];
		final char SIGNOS [] = {'1','X','2'} ;
		int napuestas;
		char qganadora[];
		String cabecera="Partido.\tRdo.\t";
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
		quiniela = new char[15][napuestas];
		qganadora= new char [15];
		
		for (int i=0;i<napuestas;i++){
			cabecera += "Ap. "+(i+1)+"\t";
		}
		
		System.out.println(cabecera);
		
		for (int i=0;i<quiniela.length;i++){
			System.out.print((i+1)+". \t\t");
			qganadora[i]=SIGNOS[aleatorio(0,2)];
			System.out.print(qganadora[i]+"\t");
			for(int j=0;j<quiniela[i].length;j++){
				quiniela[i][j]=SIGNOS[aleatorio(0,2)];
				System.out.print(quiniela[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.print("Num. Aciertos:\t");
		for(int j=0;j<napuestas;j++){
			numAciertos=0;
			for(int i=0;i<quiniela.length;i++)
				if (quiniela[i][j]==qganadora[i])
					numAciertos++;
			
			System.out.print("\t"+numAciertos+"\t");
		}
	}	
	public static int aleatorio(int min, int max){
		int numAle =  (int) Math.floor(Math.random()*(max-min+1)+min);
		return numAle;
	}
}