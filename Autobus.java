import ES.ES;

public class Autobus {
    
    public static void main(String[] args){
        int cantidadPersona = 0;
        int distanciaViaje = 0;
        int precioBase = 20; 
        double precioFinal = 0;

        do  {
            distanciaViaje = ES.leeN("Introduce la distancia del trayecto: ");
            if (distanciaViaje > 0){
                cantidadPersona = ES.leeN("Introduce el numero de personas que van juntas: ");

                if (cantidadPersona > 0){
                    if (distanciaViaje > 200) {
                        precioFinal = (distanciaViaje - 200 ) * 0.20 + precioBase; 
                        if (distanciaViaje > 400) {
                            precioFinal = precioFinal * 0.85;
                        }
                    }
                    else {
                        precioFinal = precioBase;
                    }

                    if (cantidadPersona > 3){
                        precioFinal = precioFinal * 0.90;
                    }

                    System.out.println("La cantidad total del costo del viaje son: " + (float)(precioFinal * cantidadPersona) + " euros");
                    if (cantidadPersona > 1){
                        System.out.println("La cantidad del costo del viaje por persona es: " + (float)precioFinal + " euros");
                    //le hago casting como float para quitarle algunos decimales al numero que sale 
                    }                    
                }
                else {
                    System.out.println("Introduce un numero mayor a 0");
                }

            }
        }while (distanciaViaje != 0);
    }
}