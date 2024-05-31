package Método_Trapecio;

import java.util.function.Function;

/**
 *
 * author Migue
 */
public class ejercicio4 {

    public static double integrate(double a, double b, int n, Function<Double, Double> func) {
        double h = (b - a) / n;
        double sum = 0.5 * (func.apply(a) + func.apply(b));

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += func.apply(x);
        }

        return h * sum;
    }

    public static double differentiate(double x, double h, Function<Double, Double> func) {
        double result = (func.apply(x + h) - func.apply(x - h)) / (2 * h);
        return result;
    }

    public static void main(String[] args) {
        Function<Double, Double> func = (x) -> Math.log(x); // Función: ln(x)
        double a = 1; // Límite inferior
        double b = 2; // Límite superior
        int n = 100; // Número de segmentos
        double x0 = 1.5; // Punto en el que se desea calcular la derivada
        double h = 0.01; // Tamaño del paso

        double integral = integrate(a, b, n, func);
        System.out.println("Integral de ln(x) de 1 a 2: " + integral);

        double derivative = differentiate(x0, h, func);
        System.out.println("Derivada de ln(x) en x = " + x0 + ": " + derivative);
    }
}
