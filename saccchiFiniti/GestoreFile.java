import java.io.*;
import java.util.*;

public class GestoreFile {

    public static void salvaPartita(Scacchiera scacchiera, String nomeFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeFile))) {
            for (int riga = 0; riga < 8; riga++) {
                for (int colonna = 0; colonna < 8; colonna++) {
                    Pezzo pezzo = scacchiera.getPezzo(riga, colonna);
                    if (pezzo != null) {
                        writer.println(pezzo.getClass().getSimpleName() + " " +
                                pezzo.getColore() + " " +
                                riga + " " + colonna);
                    }
                }
            }
        }
    }

    /*
     * /*public static Scacchiera caricaPartita(String nomeFile) throws IOException
     * {
     * Scacchiera scacchiera = new Scacchiera();
     * try (Scanner scanner = new Scanner(new File(nomeFile))) {
     * while (scanner.hasNextLine()) {
     * String[] dati = scanner.nextLine().split(" ");
     * String tipoPezzo = dati[0];
     * String colore = dati[1];
     * int riga = Integer.parseInt(dati[2]);
     * int colonna = Integer.parseInt(dati[3]);
     * 
     * Pezzo pezzo = creaPezzo(tipoPezzo, colore, riga, colonna);
     * scacchiera.posizionaPezzo(pezzo, riga, colonna);
     * }
     * }
     * return scacchiera;
     * }
     * 
     * /*
     * private static Pezzo creaPezzo(String tipoPezzo, String colore, int riga, int
     * colonna) {
     * switch (tipoPezzo) {
     * case "Pedone":
     * return new Pedone(colore, riga, colonna);
     * default:
     * throw new IllegalArgumentException("Tipo di pezzo sconosciuto: " +
     * tipoPezzo);
     * }
     * }
     */
}
