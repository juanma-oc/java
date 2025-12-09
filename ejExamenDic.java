import java.lang.Math;
import java.util.Arrays;
import ES.ES;

public class ejExamenDic {
	public static void main(String[] args){
		int opc;
        String butacas [][][] = new String [3][5][5];
        int sesion;
		
        sesion=ES.leeN("Introduce la sesion.. (1. Mañana, 2. Tarde, 3. Noche): ",1,3);
		inicializarSala(butacas);		
        do{ 
            System.out.println("Gestion de Butacas");
            System.out.println("1. Mostar Sala ");
            System.out.println("2. Reservar Butaca");
            System.out.println("3. Ver Disponibilidad");
			System.out.println("4. Cambiar de Sesion");
            System.out.println("5. Salir");
            opc = ES.leeN("Elije una opcion: ",1,5);

            switch (opc) {
                case 1:
                    mostarSala(butacas,sesion);
                    break;

                case 2:
                    reservarButaca(butacas,sesion);
                    break;

                case 3:
                    System.out.println("Existen "+contarLibres(butacas,sesion)+" butacas libres");
                    System.out.println("El porcentaje de ocupacion es del "+ (contarLibres(butacas,sesion)/25)+"%");
                    break;
				case 4:
					sesion=ES.leeN("Introduce la sesion.. (1. Mañana, 2. Tarde, 3. Noche)",1,3);
					break;
                default:
                    System.out.println("Saliendo..");
                    break; 
			}		
        }while (opc<5); 
	}	
	
    public static void inicializarSala(String [][][] butacas){
        for (int i=0;i<butacas.length;i++){
			for (int j=0;j<butacas[i].length;j++){
				for(int k=0;k<butacas[i][j].length;k++){
					butacas[i][j][k]="L";
				}
			}
		}	
	}

    public static void mostarSala(String [][][] butacas, int sesion){
        char[] letra = {'A','B','C','D','E'};
		
		String sesionDia;
		if (sesion==1){
			sesionDia="Manaña";
		}else if (sesion==2){
			sesionDia="Tarde";
		}else{
			sesionDia="Noche";
		}
		
		System.out.println("Sesion de "+sesionDia);
        System.out.println("\t1.\t2.\t3.\t4.\t5.");
        for (int i=0;i<butacas[sesion].length;i++){
            System.out.print(letra[i]+"\t");
            for(int j=0;j<butacas[sesion][i].length;j++){
                System.out.print(butacas[sesion][i][j]+"\t");
            }
			System.out.println();
        }    
    }

    public static void reservarButaca(String [][][] butacas, int sesion){
        String coordenada;
        int libres = contarLibres(butacas,sesion);
        int cercania;
		boolean butacaLibre=true;
		int i;
		int j;
		char[] letra = {
            'A','B','C','D','E'
        };
		
		
		System.out.println("Mostrando el estado de la sala");
        mostarSala(butacas,sesion);

        if (libres>0){
            cercania=ES.leeN("¿Quieres la butaca mas cerca o mas lejos del pantalla? (0. Elijo Yo, 1. Cerca, 2. Lejos) ",0,2);
            if (cercania==1){
				i=0;
				j=0;
				do{ 	
					if (butacas[sesion][i][j].equals("L")){
						butacas[sesion][i][j]="R";
						System.out.println("Has reservado la butaca "+letra[i]+(j+1));
						butacaLibre=false;
					}else{
						j+=1;
					}
				}while (butacaLibre);
			}else if (cercania==2){
				i=4;
				j=4;
				do{	
					if (butacas[sesion][i][j].equals("L")){
						butacas[sesion][i][j]="R";
						System.out.println("Has reservado la butaca "+letra[i]+(j+1));
						butacaLibre=false;
					}else{
						j= j -1;
					}
				}while (butacaLibre);
			}else{
				do{
                coordenada = ES.leeDeTeclado("Introduce la coordenada de la butaca que quieras elegir: ");
                if (coordenada.matches("[A-E][1-5]")==false)
                    System.out.println("La coordenada introducida no es valida");   
				}while (coordenada.matches("[A-E][1-5]")==false);
				
				// char prueba []=coordenada;
				
				// i=letra.indexOf(prueba[0]);
				// j=prueba[1]-1;
				// butacas[sesion][i][j]="R";
				
			}	
        }else{
            System.out.println("No existen butacas libres en esta sesion");
		}
    }

    public static int contarLibres(String [][][] butacas, int sesion){
        int libres=0;
        for (int i=0;i<butacas[sesion].length;i++){
            for(int j=0;j<butacas[sesion][i].length;j++){
                if(butacas[sesion][i][j].equals("L"))
                    libres+=1;
            }
        }
		return libres;
    }
}