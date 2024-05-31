package Método_Cuadratura_Gaussiana;

import java.util.function.Function;


public class ejercicio3 {

    // Coeficientes y nodos de Cuadratura Gaussiana para dos puntos
    private static final double[] nodes = {-0.5773502692, 0.5773502692};
    private static final double[] weights = {1.0, 1.0};

    // Método para calcular la integral numérica utilizando Cuadratura Gaussiana
    public static double integrate(double a, double b, Function<Double, Double> func) {
        double integral = 0.0;
        double transform = (b - a) / 2.0;

        for (int i = 0; i < nodes.length; i++) {
            double x = transform * nodes[i] + (a + b) / 2.0;
            integral += weights[i] * func.apply(x);
        }

        return transform * integral;
    }

    // Método para calcular la derivada numérica utilizando Cuadratura Gaussiana
    public static double differentiate(double x, double h, Function<Double, Double> func) {
        double derivative = 0.0;

        for (int i = 0; i < nodes.length; i++) {
            double xi = x + h * nodes[i];
            derivative += weights[i] * func.apply(xi);
        }

        return derivative / h;
    }

    public static void main(String[] args) {
        Function<Double, Double> func = (x) -> Math.log(x + 1); // Función: ln(x + 1)
        double a = 0; // Límite inferior
        double b = 1; // Límite superior
        double x0 = 0.5; // Punto en el que se desea calcular la derivada
        double h = 0.1; // Tamaño del paso

        // Calcular la integral numérica utilizando Cuadratura Gaussiana
        double integralResult = integrate(a, b, func);
        System.out.println("Integral de ln(x + 1) desde 0 a 1: " + integralResult);

        // Calcular la derivada numérica utilizando Cuadratura Gaussiana
        double derivative = differentiate(x0, h, func);
        System.out.println("Derivada de ln(x + 1) en x = " + x0 + ": " + derivative);
    }
}
