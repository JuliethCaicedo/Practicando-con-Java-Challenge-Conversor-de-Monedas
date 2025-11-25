import com.google.gson.Gson;

public class ConvierteMoneda {

    BuscaMoneda buscador = new BuscaMoneda();
    Gson gson = new Gson();

    public String convierteMoneda(double valor, String monedaOrigen, String monedaDestino){

        String jsonRespuesta = buscador.consultaMoneda();
        Moneda moneda = gson.fromJson(jsonRespuesta, Moneda.class);

        double tasaOrigen = moneda.getConversion_rates().get(monedaOrigen);
        double tasaDestino = moneda.getConversion_rates().get(monedaDestino);

         double respuesta = valor * (tasaDestino/tasaOrigen);

        String mensaje = "la conversion de " + valor + " " +monedaOrigen + " a " + monedaDestino + " es de: " + respuesta + " " + monedaDestino + "\n";
        return mensaje;
    }
}


