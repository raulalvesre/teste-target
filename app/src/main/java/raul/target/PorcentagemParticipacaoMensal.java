package raul.target;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import static raul.target.DoubleUtils.round;

//Essa é a 4
public class PorcentagemParticipacaoMensal {

    private static double somaFaturamentos;
    private static final Map<String, Double> faturamentoMensal = Map.of(
            "SP", 67836.43,
            "RJ", 36678.66,
            "MG", 29229.88,
            "ES", 27165.48,
            "OUTROS", 19849.53
    );

    public static void main(String[] args) throws IOException, ParseException {
        somaFaturamentos = faturamentoMensal.values().stream().reduce(0.0, Double::sum);

        for (var UF: faturamentoMensal.keySet()) {
            System.out.println(UF + " contribuiu " + round(calcularPorcentagem(UF), 2) + "%");
        }
    }

    private static double calcularPorcentagem(String UF) {
        return (faturamentoMensal.get(UF) / somaFaturamentos) * 100;
    }

}
