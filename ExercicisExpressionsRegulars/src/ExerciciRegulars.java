import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExerciciRegulars {
    public static void main(String[] args) {
        try {
            String file = "santako.txt";
            BufferedReader bfr = new BufferedReader(new FileReader(file));

            String line;
            String papanoel = "\\*<]:-DOo";
            String reno = ">:o\\)";
            String follet = "<]:-D$";

            Pattern papanoelPattern = Pattern.compile(papanoel);
            Pattern renoPattern = Pattern.compile(reno);
            Pattern folletPattern = Pattern.compile(follet);

            while ((line = bfr.readLine()) != null) {
                int papanoelCount = Contador(line, papanoelPattern);
                int renoCount = Contador(line, renoPattern);
                int folletCount = Contador(line, folletPattern);

                StringBuilder salida = new StringBuilder();
                if (papanoelCount > 0) {
                    salida.append("Pare Noel (").append(papanoelCount).append(") ");
                }
                if (renoCount > 0) {
                    salida.append("Ren (").append(renoCount).append(") ");
                }
                if (folletCount > 0) {
                    salida.append("Follet (").append(folletCount).append(") ");
                }
                System.out.println(salida.toString().trim());
            }

            bfr.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static int Contador(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        int contador = 0;
        while (matcher.find()) {
            contador++;
        }
        return contador;
    }
}
