import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Maneggio {
    Cavallo[] cavalli = new Cavallo[10];
    int indice = 0;

    public Maneggio() {
        try (FileReader fr = new FileReader("cavalli.csv");
             Scanner in = new Scanner(fr);
             PrintWriter pw = new PrintWriter(new FileWriter("copia.csv"))) {

            in.nextLine();
            while (in.hasNextLine() && indice < cavalli.length) {
                String linea = in.nextLine();
                String[] campi = linea.split(",");

                String nome = campi[0];
                int eta = Integer.parseInt(campi[1]);
                String razza = campi[2];
                String colore = campi[3];
                String proprietario = campi[4];

                cavalli[indice] = new Cavallo(nome, eta, razza, colore, proprietario);
                indice++;
            }

            for (int i = 0; i < indice; i++) {
                pw.println(cavalli[i].toString());
            }

        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }

    public void ordinaCavalli() {
        for (int i = 0; i < indice - 1; i++) {
            for (int j = i + 1; j < indice; j++) {
                if (cavalli[i].toString().compareTo(cavalli[j].toString()) > 0) {
                    Cavallo temp = cavalli[i];
                    cavalli[i] = cavalli[j];
                    cavalli[j] = temp;
                }
            }
        }
    }
}
