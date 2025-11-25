import com.google.gson.Gson;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)  {
        Scanner teclado = new Scanner(System.in);
        BuscaMoneda buscador = new BuscaMoneda();
        ConvierteMoneda conversor = new ConvierteMoneda();
        Gson gson = new Gson();

        String menu = """
                ********************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dólar =>>> Peso Argentino
                2) Peso Argentino =>>> Dólar
                3) Dólar =>>> Real Brasileño
                4) Real Brasileño =>>> Dólar
                5) Dólar =>>> Peso Colombiano
                6) Peso Colombiano =>>> Dólar
                7) Salir
                Elija una opcion valida:
                **********************************************
                """;

        while (true) {
            System.out.println(menu);

            int opcion;

            try {
                opcion = teclado.nextInt();
            }catch (InputMismatchException e ){
                System.out.println("Debe ingresar un número válido.");
                teclado.nextLine();
                continue;
            }

            String monedaOrigen;
            String monedaDestino;

            switch (opcion){
                case  1 :
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    break;
                case  2 :
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    break;
                case  3 :
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    break;
                case  4 :
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    break;
                case  5 :
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    break;
                case  6 :
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    break;
                case 7 :
                    System.out.println("Gracias por usar el conversor. Hasta pronto.");
                    return;
                default:
                    System.out.println("Opcion no valida");
                    continue;
            }
            System.out.println("Ingrese el valor a convertir");
            double valor;

            try {
                valor = teclado.nextDouble();
            } catch (InputMismatchException e ) {
                System.out.println("Debe ingresar un número válido.");
                teclado.nextLine();
                continue;

            }

            var valorconvertido = conversor.convierteMoneda(valor,monedaOrigen,monedaDestino);
            System.out.println(valorconvertido);
        }
    }
}
