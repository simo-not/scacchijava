import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il nome del primo giocatore (Bianco): ");
        String nomeBianco = scanner.nextLine();
        System.out.print("Inserisci il nome del secondo giocatore (Nero): ");
        String nomeNero = scanner.nextLine();

        Giocatore giocatoreBianco = new Giocatore(nomeBianco, "bianco");
        Giocatore giocatoreNero = new Giocatore(nomeNero, "nero");

        Scacchiera scacchiera = new Scacchiera();
        Giocatore giocatoreCorrente = giocatoreBianco;

        while (true) {
            visualizzaScacchiera(scacchiera);
            System.out.println("Turno di " + giocatoreCorrente.getNome());

            System.out.print("Inserisci la mossa (es. e2 e4) o digita 'exit' per uscire: ");
            String mossa = scanner.nextLine();

            if (mossa.equalsIgnoreCase("exit")) {
                System.out.print("Vuoi salvare la partita prima di uscire? (s/n): ");
                String risposta = scanner.nextLine();
                if (risposta.equalsIgnoreCase("s")) {
                    System.out.print("Inserisci il nome del file per salvare la partita: ");
                    String nomeFile = scanner.nextLine();
                    try {
                        GestoreFile.salvaPartita(scacchiera, nomeFile);
                        System.out.println("Partita salvata con successo.");
                    } catch (Exception e) {
                        System.out.println("Errore durante il salvataggio della partita.");
                    }
                }
                break;
            }

            String[] mossaDivisa = mossa.split(" ");
            if (mossaDivisa.length != 2) {
                System.out.println("Formato della mossa non valido. Riprova.");
                continue;
            }

            int rigaIniziale = 8 - Character.getNumericValue(mossaDivisa[0].charAt(1));
            int colonnaIniziale = mossaDivisa[0].charAt(0) - 'a';
            int nuovaRiga = 8 - Character.getNumericValue(mossaDivisa[1].charAt(1));
            int nuovaColonna = mossaDivisa[1].charAt(0) - 'a';

            Pezzo pezzo = scacchiera.getPezzo(rigaIniziale, colonnaIniziale);
            if (pezzo != null && pezzo.getColore().equals(giocatoreCorrente.getColore()) &&
                    pezzo.mossaValida(scacchiera, nuovaRiga, nuovaColonna)) {
                scacchiera.muoviPezzo(rigaIniziale, colonnaIniziale, nuovaRiga, nuovaColonna);

                if (scacchiera.èScaccoMatto(giocatoreCorrente == giocatoreBianco ? "nero" : "bianco")) {
                    visualizzaScacchiera(scacchiera);
                    System.out.println("Scacco matto! " + giocatoreCorrente.getNome() + " ha vinto!");
                    break;
                }

                giocatoreCorrente = (giocatoreCorrente == giocatoreBianco) ? giocatoreNero : giocatoreBianco;
            } else {
                System.out.println("Mossa non valida. Riprova.");
            }
        }

        scanner.close();
    }

    private static void visualizzaScacchiera(Scacchiera scacchiera) {
        System.out.println("  a b c d e f g h");
        for (int riga = 0; riga < 8; riga++) {
            System.out.print(8 - riga + " ");
            for (int colonna = 0; colonna < 8; colonna++) {
                Pezzo pezzo = scacchiera.getPezzo(riga, colonna);
                if (pezzo == null) {
                    System.out.print(". ");
                } else {
                    String simbolo = getSimboloPezzo(pezzo);
                    System.out.print(simbolo + " ");
                }
            }
            System.out.println(8 - riga);
        }
        System.out.println("  a b c d e f g h");
    }

    private static String getSimboloPezzo(Pezzo pezzo) {
        String simbolo = "";
        switch (pezzo.getClass().getSimpleName()) {
            case "Pedone":
                simbolo = pezzo.getColore().equals("bianco") ? "P" : "p";
                break;
            case "Torre":
                simbolo = pezzo.getColore().equals("bianco") ? "T" : "t";
                break;
            case "Cavallo":
                simbolo = pezzo.getColore().equals("bianco") ? "C" : "c";
                break;
            case "Alfiere":
                simbolo = pezzo.getColore().equals("bianco") ? "A" : "a";
                break;
            case "Regina":
                simbolo = pezzo.getColore().equals("bianco") ? "D" : "d";
                break;
            case "Re":
                simbolo = pezzo.getColore().equals("bianco") ? "R" : "r";
                break;
        }
        return simbolo;
    }
}
