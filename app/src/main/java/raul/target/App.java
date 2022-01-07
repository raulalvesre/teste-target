package raul.target;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import static raul.target.DoubleUtils.round;

// Essa é a 3
public class App {

    private class FaturamentoDiario {
        int dia;
        double valor;
    }

    public static void main(String[] args) throws IOException, ParseException {
        String jsonArrayString = getJsonDataAsString();
        var faturamentosDiarios = getFaturamentosListFromJsonArrayString(jsonArrayString);

        DoubleSummaryStatistics stats = faturamentosDiarios.stream()
                .mapToDouble(x -> x.valor)
                .filter(x -> x > 0)
                .summaryStatistics();

        double media = round(stats.getAverage(), 2);
        long numDiasComValorMaiorQueAMedia = faturamentosDiarios.stream()
                .filter(x -> x.valor > media)
                .count();

        System.out.println("Menor valor (maior que zero): " + stats.getMin());
        System.out.println("Maior valor: " + stats.getMax());
        System.out.println("Média: " + media);
        System.out.println("Números de dias com valor maior que a média: " + numDiasComValorMaiorQueAMedia);
    }

    private static String getJsonDataAsString() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("dados.json");
        return new String(is.readAllBytes(), StandardCharsets.UTF_8);
    }

    private static List<FaturamentoDiario> getFaturamentosListFromJsonArrayString(String jsonArrayString) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<FaturamentoDiario>>(){}.getType();
        return gson.fromJson(jsonArrayString, type);
    }

}