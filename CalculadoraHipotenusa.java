import java.lang.Math; //java.util.Math

public class CalculadoraHipotenusa {

    public static void main(String[] args) {

        double catetoA = 3.5;

        double catetoB = 4.0;

        double hipotenusa;

        double cuadradoA = catetoA * catetoA ; //catetoA * 2;

        double cuadradoB = catetoB * catetoB; // catetoB * 2;

        double sumaCuadrados = cuadradoA + cuadradoB;

        hipotenusa = Math.sqrt(sumaCuadrados);

        double resultado = hipotenusa; // (int) hipotenusa

        System.out.println("La hipotenusa es: " + resultado);

    }
}