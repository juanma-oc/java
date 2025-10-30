import ES.ES;
import java.lang.Math;
public class Billetes {
	
	public static float redondear(float numero, int dec){
		float numCalculado = (float) (Math.round((numero)*(10^dec))/(10^dec));
		return numCalculado;
	}
	
	public static void main(String[] args){
		float distancia;
		int numPersonas;
		float precioBillete;
		float precioTotal;

		//Entrada de datos
		distancia = (float) ES.leeNR("Introduce distancia: ");
		numPersonas = ES.leeN("Introduce número de personas: ",1);

		//Proceso
		precioBillete=20;
		if (distancia>200){
			System.out.println("Incremento precio x km (>200): "+(distancia-200)*0.20);
			precioBillete+= (distancia-200)*0.20;
			if (distancia>400){
				System.out.println("Descuento aplicado (d>400km): "+redondear(precioBillete*0.15f,2));
				precioBillete-= precioBillete*0.15;
			}
		}
		
		if (numPersonas>=3){
			//System.out.println("Descuento aplicado (num>=3): "+(float) (Math.round((precioBillete*0.10)*100))/100);
			System.out.println("Descuento aplicado (num>=3): "+redondear(precioBillete*0.10f,2));
			precioBillete-= precioBillete*0.10;
		}
		precioTotal = precioBillete * numPersonas;
		
		//Salida de datos
		System.out.println("El billete individual cuesta "+redondear(precioBillete,2)+'E');
		System.out.println("El importe total para "+numPersonas+" personas es de "+redondear(precioTotal,2)+'E');
		
	}
}