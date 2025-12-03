import ES.ES;
import java.util.Arrays;

public class examenADic{
    public static void main(String[] args){
		
		final int MAXJUG = 10;
		String[][][] jugadores = new String[3][MAXJUG][3];
		int opc = 0;
		String[] opciones = {"Agregar jugador","Listar estadísticas","Actualizar estadísticas","Calcular Promedio","Buscar jugadores"};
		int indice=0;
		
		inicializarEquipo(jugadores);
		do{
			opc = pintaMenu(opciones);
			switch(opc){
				case 1:
						agregarJugador(jugadores,indice);
						indice++;
						break;
				case 2:
						listarEstadisticas(jugadores,indice);
						break;
				case 3:
						actualizarEstadisticas(jugadores);
						break;
				case 4:
						calcularPromedio(jugadores);
						break;
				case 5:
						buscarJugadores(jugadores);
						break;
			}
		}while (opc!=0);
		
	}
	
	public static void inicializarEquipo(String[][][] jug){
		for(int i=0;i<jug.length;i++)
			for(int j=0;j<jug[i].length;j++)
				for(int k=0;k<=jug[i][j].length;k++)
					jug[i][j][k]="Vacío";
	}
	
	public static int pintaMenu(String[] menu){
		for(int i=0;i<menu.length;i++)
			System.out.println((i+1)+". "+menu[i]);
		System.out.println("\n0. Salir");
		return ES.leeN("Elige una opción: ",0,menu.length);
	}
	
	public static void agregarJugador(String[][][] jug,int ind){
		int temporada=ES.leeN("Introduce temporada (1-3): ", 1,3);
		temp--;
		
		String nombre=ES.leeDeTeclado("Introduce nombre de jugador: ");
		
		if (ind==jug.length)
			System.out.println("No hay capacidad para más jugadores");
		else{
			jug[temp][ind][0]=nombre;
			jug[temp][ind][1]="0";
			jug[temp][ind][2]="0";
			System.out.println("Jugador añadido.");
		}
	}
	
	public static void listarEstadisticas(String[][][] jug, int numJug){
		System.out.println("\n****** Estadísticas ******\n");
			
		for(int k=0;k<jug.length;k++){
			System.out.println("\tNombre\tPuntos\tPartidos");
				for(int i=0;i<numJug;i++){
					for(int j=0;j<jug[k][i].length;j++)
						System.out.print("\t"+jug[k][i][j]);
					System.out.println();
				}
			System.out.println();
		}
	}
	
	public static void actualizarEstadisticas(String[][] jug){
		int pos=encontrarJugador(jug);
		if(pos>=0){
			int puntos = ES.leeN("Introduce número de puntos: ");
			jug[pos][1] = String.valueOf(Integer.parseInt(jug[pos][1])+puntos);
			jug[pos][2] = String.valueOf(Integer.parseInt(jug[pos][2])+1);
			System.out.println("Jugador actualizado.");
		}
		else
			System.out.println("No se ha encontrado jugador con ese nombre...");
	}
	
	public static void calcularPromedio(String[][] jug){
		int pos=encontrarJugador(jug);
		if(pos>=0){
			float promedio=Float.parseFloat(jug[pos][1])/Float.parseFloat(jug[pos][2]);
			System.out.println(jug[pos][0]+" tiene un promedio de "+promedio+" puntos por partido.");
		}
		else
			System.out.println("No se ha encontrado jugador con ese nombre...");
	}
	
	public static int encontrarJugador(String[][] jug){
		String nombre=ES.leeDeTeclado("Introduce el nombre del jugador: ");
		for(int i=0;i<jug.length;i++)
			if(jug[i][0].equals(nombre)){
				return i;
			}
		return -1;
	}
	
	public static void buscarJugadores(String[][] jug){
		String letras=ES.leeDeTeclado("Introduce las primeras letras: ");
		System.out.println("Jugadores que empiezan por "+letras+":");
		for(int i=0;i<jug.length;i++)
			if(jug[i][0].startsWith(letras)){
				System.out.print("\t"+jug[i][0]);
			}
		System.out.println();
	}
}