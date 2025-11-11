import java.util.Arrays;
import ES.ES;

//No se me ha corregido la parte del calcularValorTotal completa ni la funcion ni lo de mostrar
public class sistemaInventario {
	
	public static void main(String[] args){
		String inventario [][] = new String[100][4];
		
		cargarProductos(inventario);
		listarProductos(inventario);
		
		encarecerExtranjeros(inventario);
		listarProductos(inventario);
		
		System.out.println("El producto con el precio unitario mas bajo es: " + obtenerProductoMasBarato(inventario));
		System.out.println("El stock promedio por producto es: "+ calcularStockPromedio(inventario));
		
		int num = ES.leeN("Introduce el numero del artículo del que se desea calcular el Valor Total: ");
		int fila = num - 1;
		System.out.println("El valor total en stock del producto"+num+" es: "+calcularValorTotal(inventario,fila));

	}

	public static int calcularValorTotal(String[][] prods, int numFila){
		int valorStock;
		int cantidad = Integer.parseInt(prods[numFila][1]);
		int precio = Integer.parseInt(prods[numFila][3]);
		String extranj = prods[numFila][2];
		valorStock = cantidad * precio;
		
		if (extranj.equals("Si") && valorStock < 1500)
			return 1500;
		else
			return valorStock;
	}

	public static float calcularStockPromedio(String[][] prods){
		float stockprom = 0;
		int numProd = 1;
		for (int i=0;i<prods.length;i++){
			if (prods[i][0]!=null){
				stockprom += Integer.parseInt(prods[i][1]);
				numProd = (i+1); 
			}	
		}
		stockprom = (float) redondear((stockprom / numProd),2);
		return stockprom;
	}

	public static float obtenerProductoMasBarato(String[][] prods){
		float precioMin = 100;
		float precio;
		for (int i=0;i<prods.length;i++){
			if (prods[i][0]!=null){
				precio = Float.parseFloat(prods[i][3]);
				if (precio < precioMin)
					precioMin = precio;
			}	
		}
		return precioMin;
	}

	public static int encarecerExtranjeros(String[][] prods){
		int cantMod = 0;
		String comprob;
		float num;
		double encarecer;
		for (int i=0;i<prods.length;i++){
			if (prods[i][0]!=null){
				comprob = prods[i][2];
				if (!(comprob.equals("")) && comprob.equals("Si")){
					num = Float.parseFloat(prods[i][3]);
					encarecer = num + (num*0.2);
					prods[i][3] = String.valueOf(encarecer);
					cantMod = cantMod + 1;
				}
			}	
		}
		return cantMod;
	}
	
	
	public static void listarProductos (String [][] prods){
		System.out.println("\tNombre"+"\t\tCantidad"+"\t\tExtranjero?"+"\tPrecio");
		for (int i=0;i<prods.length;i++)
			if (prods[i][0]!=null)
				System.out.println("\t"+prods[i][0]+"\t\t"+prods[i][1]+"\t\t"+prods[i][2]+"\t\t"+prods[i][3]);
	}	
	
	public static void cargarProductos(String[][] prods){
		int i=0;
		String nombre;
		float precio;
		int cantidad;
		String extranj;
		
		do{ 
			nombre = ES.leeDeTeclado("Introduce el nombre del producto: ");
			if (!(nombre.equals(""))){
				cantidad = aleatorio(10,150);
				extranj = aleatorioExtranj(1,2);
				precio = (float) aleatorio(5,100);
				prods[i][0] = nombre;
				prods[i][1] = String.valueOf(cantidad);
				prods[i][2] = extranj;
				prods[i][3] = String.valueOf(precio);
				i++;
			}
		}while ((i<prods.length) && !(nombre.equals("")));
	}
	
	public static int aleatorio(int min, int max){
		int numAle =  (int) Math.floor(Math.random()*(max-min+1)+min);
		return numAle;
	}
	
	public static String aleatorioExtranj(int min, int max){
		int numAle =  (int) Math.floor(Math.random()*(max-min+1)+min);
		if (numAle%2==0)
			return "Si";
		else
			return "No";
	}
	
	public static float redondear(float numero, int dec){	
		return (float) (Math.round((numero)*(Math.pow(10,dec)))/(Math.pow(10,dec)));
	}
}