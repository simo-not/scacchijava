import java.util.Random;
import java.util.Scanner;

public class MainScacchi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n1, n2;
        int colore2 = 0;
        System.out.println("inserire il nome del giocatore 1: ");
        n1 = scanner.nextLine();
        System.out.println("inserire il nome del giocatore 2: ");
        n2 = scanner.nextLine();
        Random random = new Random();
        int nColore = 0;
        int nGiocatore = 0;
        nColore = random.nextInt(2);
        if (nColore == 1) {
            colore2 = 0;
        } else
            colore2 = 1;
        Giocatore giocatore1 = new Giocatore(n1, nColore);
        Giocatore giocatore2 = new Giocatore(n2, colore2);
    }
}
