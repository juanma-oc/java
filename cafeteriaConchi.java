import java.util.Arrays;
import ES.ES;

public class cafeteriaConchi {
	
	public static void main(String[] args){
		String productos [][] = new String[10][2];
		String ventas [][] = new String[100][4];
		
		String nombre;
		int cantidad;
		int i=0;
		float precio, total;
		
		cargarProductos(productos);
		listarProductos(productos);
		
		do {
			nombre = ES.leeDeTeclado("Introduce el nombre del producto: ");
			if (!(nombre.equals(""))){
				cantidad =  ES.leeN("Introduce la cantidad a pedir: ",1,30);
				precio = encontrarPrecio(productos,nombre);
				if (precio==-1)
					System.out.println("El producto introducido no existe.");
				else {
					total = cantidad*precio;
					ventas[i][0]=nombre;
					ventas[i][1]=String.valueOf(precio);
					ventas[i][2]=String.valueOf(cantidad);
					ventas[i][3]=String.valueOf(total);
					i++;
				}
			}
		} while (!(nombre.equals("")));
		
		//calcularTotalDia(ventas);
	}

	public static float encontrarPrecio(String[][] prods, String nombre){
		int i = 0;
		while ((i<prods.length) && !prods[i][0].equals(nombre)){
			i++;
		}
		
		if (i==prods.length)
			return -1;
		else 
			return Float.parseFloat(prods[i][1]);
	}

	public static void cargarProductos(String[][] prods){
		int i=0;
		String nombre;
		float precio;
		do{ 
			nombre = ES.leeDeTeclado("Introduce el nombre del producto: ");
			if (!(nombre.equals(""))){
				precio = (float) ES.leeNR("Introduce el precio del producto: ");
				prods[i][0] = nombre;
				prods[i][1] = String.valueOf(precio);
				i++;
			}
		}while ((i<prods.length) && !(nombre.equals("")));
	}
		
	public static void listarProductos (String [][] prods){
		System.out.println("\tProducto"+"\t\tPrecio");
		for (int i=0;i<prods.length;i++)
			if (prods[i][0]!=null)
				System.out.println("\t"+prods[i][0]+"\t\t"+prods[i][1]);
	}	
}